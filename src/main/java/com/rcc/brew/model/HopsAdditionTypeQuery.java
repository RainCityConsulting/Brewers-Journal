package com.rcc.brew.model;

import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface HopsAdditionTypeQuery extends BeanQuery<HopsAdditionType> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public HopsAdditionType findById(int id);
    public List<HopsAdditionType> findAll();
    public List<HopsAdditionType> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
