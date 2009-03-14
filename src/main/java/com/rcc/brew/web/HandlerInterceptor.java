package com.rcc.brew.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
     
public class HandlerInterceptor extends HandlerInterceptorAdapter {

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
        throws Exception
    {       
        if (modelAndView == null) { return; }
        if (modelAndView.getViewName() != null
                && modelAndView.getViewName().startsWith("redirect:"))
        {
            return;
        }

        modelAndView.addObject("user", request.getSession().getAttribute("user"));
    }
}
