package com.hmall.gateway.filter;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.hmall.common.exception.UnauthorizedException;
import com.hmall.gateway.config.AuthProperties;
import com.hmall.gateway.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component //将过滤器交给spring容器管理
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered
{
    private final AuthProperties authProperties;
    private final JwtTool jwtTool;
    private final AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        //登录校验
        //1.获取请求头
        ServerHttpRequest request = exchange.getRequest();
        //2.判断请求路径是否在excludePaths中
        List<String> excludePaths = authProperties.getExcludePaths();
        for (String excludePath : excludePaths)
        {
            if (antPathMatcher.match(excludePath,request.getPath().toString()))
            {
                //如果在excludePaths中，则直接放行
                return chain.filter(exchange);
            }
        }
        //3.获取token
        List<String> headers = request.getHeaders().get("authorization");
        String token=null;
        if (!CollectionUtils.isEmpty(headers))
        {
            token=headers.get(0);
        }
        //4.校验jwt，得到userId
        Long userId;
        try
        {
            userId= jwtTool.parseToken(token);
        } catch (UnauthorizedException e)
        {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //5.传递用户信息
        ServerWebExchange serverWebExchange = exchange.mutate()
                .request(builder -> builder.header("user-info", userId.toString()))
                .build();
        //6.返回
        return chain.filter(serverWebExchange);
    }

    @Override
    public int getOrder()
    {
        //返回值越小，优先级越高
        return 0;
    }
}
