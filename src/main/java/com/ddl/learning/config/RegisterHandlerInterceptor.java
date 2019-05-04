package com.ddl.learning.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration(value = "WebMvcConfigurer")
@Slf4j
//public class RegisterHandlerInterceptor implements WebMvcConfigurer {
public class RegisterHandlerInterceptor extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("-----addInterceptors----");
        //注册拦截器 拦截规则
        //多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public static HandlerInterceptor getHandlerInterceptor() {
        log.info("-----initHandlerInterceptor----");
        return new CustomHandlerInterceptor();
    }
}
