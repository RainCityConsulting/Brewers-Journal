package com.rcc.brew.model;

import com.rcc.brew.bean.Adjunct;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface AdjunctQuery extends BeanQuery<Adjunct> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Adjunct findById(int id);
    public List<Adjunct> findAll();
    public List<Adjunct> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
