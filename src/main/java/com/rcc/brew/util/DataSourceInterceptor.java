package com.rcc.brew.util;

import com.rcc.brew.bean.User;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
        
public class DataSourceInterceptor implements MethodInterceptor {
    private static final Log log = LogFactory.getLog(DataSourceInterceptor.class);

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();

        if (!method.getName().equals("getConnection")) {
            return invocation.proceed();
        }
            
        Connection conn = (Connection) invocation.proceed();
        
        RequestContext context = ContextUtils.getRequestContext(false);
        if (context == null) {
            this.setUserId(conn, 0);
        } else {
            User user = context.getUser();
            if (user == null) {
                this.setUserId(conn, 0);
            } else {
                this.setUserId(conn, user.getId());
            }
        }
            
        return conn;
    }

    private void setUserId(Connection conn, int userId) throws SQLException {
        if (log.isDebugEnabled()) { log.debug("Setting @user_id: " + userId); }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("SET @user_id = " + userId);
        } finally { if (stmt != null) { stmt.close(); } }
    }   
}       
