package com.rcc.brew.model;

import com.rcc.brew.bean.GravityReadingType;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface GravityReadingTypeQuery extends BeanQuery<GravityReadingType> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public GravityReadingType findById(int id);
    public List<GravityReadingType> findAll();
    public List<GravityReadingType> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
