package com.rcc.brew.model;

import com.rcc.brew.bean.WeightUnit;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class WeightUnitQueryImpl extends ModelBase implements WeightUnitQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public WeightUnit findById(int id) {
        return this.model.findWeightUnitById(id);
    }

    public List<WeightUnit> findAll() {
        return this.model.findAllWeightUnits();
    }

    public List<WeightUnit> findAll(int offset, int limit) {
        return this.model.findAllWeightUnits(offset, limit);
    }

    public int findCount() {
        return this.model.findWeightUnitCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
