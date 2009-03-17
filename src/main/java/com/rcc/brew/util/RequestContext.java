package com.rcc.brew.util;

import com.rcc.brew.bean.User;

public class RequestContext {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
