package com.rcc.brew.model;

import com.rcc.brew.bean.GravityUnit;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class GravityUnitQueryImpl extends ModelBase implements GravityUnitQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public GravityUnit findById(int id) {
        return this.model.findGravityUnitById(id);
    }

    public List<GravityUnit> findAll() {
        return this.model.findAllGravityUnits();
    }

    public List<GravityUnit> findAll(int offset, int limit) {
        return this.model.findAllGravityUnits(offset, limit);
    }

    public int findCount() {
        return this.model.findGravityUnitCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
