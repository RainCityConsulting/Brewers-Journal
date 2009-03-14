package com.rcc.brew.model;

import com.rcc.brew.bean.User;

import com.rcc.model.ModelBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class ModelImpl extends ModelBase implements Model {

    /* USER */

    public int createUser(User u) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertUser", u);
        return id.intValue();
    }

    public void updateUser(User u) {
        this.getSqlMapClientTemplate().update("updateUser", u);
    }

    public User findUserById(int id) {
        User u = (User) this.getSqlMapClientTemplate().queryForObject("findUserById", id);
        if (u == null) { throw new ObjectNotFoundException("User ID: " + id); }
        return u;
    }

    public User findUserByName(String name) {
        return (User) this.getSqlMapClientTemplate().queryForObject("findUserByName", name);
    }

    public User findUserByMail(String mail) {
        return (User) this.getSqlMapClientTemplate().queryForObject("findUserByMail", mail);
    }

    /* END USER */
}
