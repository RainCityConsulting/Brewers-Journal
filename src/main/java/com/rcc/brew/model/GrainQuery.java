package com.rcc.brew.model;

import com.rcc.brew.bean.Grain;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface GrainQuery extends BeanQuery<Grain> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Grain findById(int id);
    public List<Grain> findAll();
    public List<Grain> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
