package com.rcc.brew.model;

import com.rcc.brew.bean.Hops;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface HopsQuery extends BeanQuery<Hops> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Hops findById(int id);
    public List<Hops> findAll();
    public List<Hops> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
