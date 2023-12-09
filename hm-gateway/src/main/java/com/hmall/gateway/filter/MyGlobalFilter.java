//package com.hmall.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component //将过滤器交给spring容器管理
//public class MyGlobalFilter implements GlobalFilter, Ordered
//{
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
//    {
//        //获取请求头
//        ServerHttpRequest request = exchange.getRequest();
//        System.out.println("request = " + request);
//        //返回
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder()
//    {
//        //返回值越小，优先级越高
//        return 0;
//    }
//}
