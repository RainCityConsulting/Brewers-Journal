package com.rcc.brew.web;

import com.rcc.brew.bean.User;
import com.rcc.brew.util.ContextUtils;
import com.rcc.brew.util.RequestContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Log log = LogFactory.getLog(ContextHandlerInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler)
        throws Exception
    {
        RequestContext context = ContextUtils.getRequestContext(true);
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) { context.setUser(user); }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex)
        throws Exception
    {
        ContextUtils.removeRequestContext();
    }
}
