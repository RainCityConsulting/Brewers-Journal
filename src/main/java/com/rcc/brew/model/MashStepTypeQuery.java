package com.rcc.brew.model;

import com.rcc.brew.bean.MashStepType;
import com.rcc.model.BeanQuery;

import java.util.List;

public interface MashStepTypeQuery extends BeanQuery<MashStepType> {
    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public MashStepType findById(int id);
    public List<MashStepType> findAll();
    public List<MashStepType> findAll(int offset, int limit);
    public int findCount(); 
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
