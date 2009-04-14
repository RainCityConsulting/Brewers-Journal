package com.rcc.brew.model;

import com.rcc.brew.bean.Yeast;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface YeastQuery extends BeanQuery<Yeast> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Yeast findById(int id);
    public List<Yeast> findAll();
    public List<Yeast> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
