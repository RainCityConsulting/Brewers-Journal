package com.rcc.brew.web;

import com.rcc.brew.bean.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Set;

public class UserRoleAuthorizationHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Log log = LogFactory.getLog(UserRoleAuthorizationHandlerInterceptor.class);

    private Set<String> authorizedRoleNames;

    public void setAuthorizedRoleNames(Set<String> authorizedRoleNames) {
        this.authorizedRoleNames = authorizedRoleNames;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler)
        throws Exception
    {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            throw new NotAuthorizedException();
        }

        for (String n : this.authorizedRoleNames) {
            if (!user.hasRole(n)) {
                throw new NotAuthorizedException();
            }
        }

        return true;
    }
}
