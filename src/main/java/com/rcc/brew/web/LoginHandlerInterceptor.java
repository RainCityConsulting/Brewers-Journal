package com.rcc.brew.web;

import com.rcc.brew.bean.User;

import com.rcc.web.FlashUtils;
import com.rcc.web.HistoryUtils;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Log log = LogFactory.getLog(LoginHandlerInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler)
        throws Exception
    {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            FlashUtils.messageCode("login.required", request);
            int last = HistoryUtils.last(request);
            throw new ModelAndViewDefiningException(
                    new ModelAndView("redirect:/user/login.s?d=" + last));
        }

        return true;
    }
}
