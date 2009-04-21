package com.rcc.brew.model;

import com.rcc.brew.bean.TempUnit;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface TempUnitQuery extends BeanQuery<TempUnit> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public TempUnit findById(int id);
    public List<TempUnit> findAll();
    public List<TempUnit> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
