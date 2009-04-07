package com.rcc.brew.model;

import com.rcc.brew.bean.TimeUnit;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface TimeUnitQuery extends BeanQuery<TimeUnit> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public TimeUnit findById(int id);
    public List<TimeUnit> findAll();
    public List<TimeUnit> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
