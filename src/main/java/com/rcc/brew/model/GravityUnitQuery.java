package com.rcc.brew.model;

import com.rcc.brew.bean.GravityUnit;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface GravityUnitQuery extends BeanQuery<GravityUnit> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public GravityUnit findById(int id);
    public List<GravityUnit> findAll();
    public List<GravityUnit> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
