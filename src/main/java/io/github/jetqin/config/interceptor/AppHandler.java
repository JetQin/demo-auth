/** 
 * Project Name:demo-auth 
 * File Name:AppHandler.java 
 * Package Name:io.github.jetqin.config.interceptor
 * Date:May 22, 20174:40:59 PM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package io.github.jetqin.config.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: AppHandler
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
public class AppHandler extends HandlerInterceptorAdapter
{

    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
        if ( response.getStatus() == 500 ) {
            modelAndView.setViewName("500");
        }
        else if ( response.getStatus() == 404 ) {
            modelAndView.setViewName("404");
        }
    }

}
