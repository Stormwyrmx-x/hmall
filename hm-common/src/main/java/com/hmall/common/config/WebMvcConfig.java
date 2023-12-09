package com.hmall.common.config;

import com.hmall.common.interceptor.UserInfoInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@ConditionalOnClass(DispatcherServlet.class)
//DispatcherServlet是SpringMVC的核心组件，当DispatcherServlet在类路径下时，才会装载这个bean
public class WebMvcConfig implements WebMvcConfigurer
{
    private final UserInfoInterceptor userInfoInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(userInfoInterceptor);
    }
}
