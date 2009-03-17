package com.rcc.brew.bean;

public class User extends com.rcc.brew.bean.gen.User {
    public boolean hasRole(String name) {
        if (this.roles == null || this.roles.isEmpty()) {
            return false;
        }
        for (UserRole r : this.roles) {
            if (r.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
