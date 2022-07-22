package com.exentric.demo2.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class DemoInterceptor implements HandlerInterceptor {
    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse
    // response, Object handler)
    // throws Exception {
    // System.out.println("execute DemoInterceptor's preHandle method");
    // return true;
    // }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("execute DemoInterceptor's preHandle method");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

}
