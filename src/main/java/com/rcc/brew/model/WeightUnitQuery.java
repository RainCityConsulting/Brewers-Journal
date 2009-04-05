package com.rcc.brew.model;

import com.rcc.brew.bean.WeightUnit;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface WeightUnitQuery extends BeanQuery<WeightUnit> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public WeightUnit findById(int id);
    public List<WeightUnit> findAll();
    public List<WeightUnit> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
