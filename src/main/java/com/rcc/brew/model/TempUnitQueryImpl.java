package com.rcc.brew.model;

import com.rcc.brew.bean.TempUnit;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class TempUnitQueryImpl extends ModelBase implements TempUnitQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public TempUnit findById(int id) {
        return this.model.findTempUnitById(id);
    }

    public List<TempUnit> findAll() {
        return this.model.findAllTempUnits();
    }

    public List<TempUnit> findAll(int offset, int limit) {
        return this.model.findAllTempUnits(offset, limit);
    }

    public int findCount() {
        return this.model.findTempUnitCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
