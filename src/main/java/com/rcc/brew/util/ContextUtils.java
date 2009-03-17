package com.rcc.brew.util;

import com.rcc.brew.bean.User;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ContextUtils {
    private static final ThreadLocal<RequestContext> requestContexts =
            new ThreadLocal<RequestContext>();

    public static void setRequestContext(RequestContext context) {
        if (requestContexts.get() != null) {
            throw new IllegalStateException("ThreadLocal RequestContext should not be set");
        }

        requestContexts.set(context);
    }

    public static RequestContext getRequestContext(boolean create) {
        RequestContext context = requestContexts.get();
        if (context == null && create) {
            context = new RequestContext();
            setRequestContext(context);
        }
        return context;
    }

    public static RequestContext getRequestContext() {
        return getRequestContext(false);
    }

    public static void removeRequestContext() {
        requestContexts.remove();
    }
}
