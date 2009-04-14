package com.rcc.brew.model;

import com.rcc.brew.bean.VolumeUnit;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface VolumeUnitQuery extends BeanQuery<VolumeUnit> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public VolumeUnit findById(int id);
    public List<VolumeUnit> findAll();
    public List<VolumeUnit> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
