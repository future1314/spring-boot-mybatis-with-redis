package com.ddl.learning.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.http.*;

@Slf4j
public class CustomHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("1-preHandle:请求前调用");
        //返回 false 则请求中断
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("2-postHandle:请求后调用");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("3-afterCompletion:请求调用完成后回调方法，即在视图渲染完成后回调");

    }//https://blog.lqdev.cn/2018/07/19/springboot/chapter-seven/

}
