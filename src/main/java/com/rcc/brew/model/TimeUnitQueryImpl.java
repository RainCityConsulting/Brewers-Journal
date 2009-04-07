package com.rcc.brew.model;

import com.rcc.brew.bean.TimeUnit;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class TimeUnitQueryImpl extends ModelBase implements TimeUnitQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public TimeUnit findById(int id) {
        return this.model.findTimeUnitById(id);
    }

    public List<TimeUnit> findAll() {
        return this.model.findAllTimeUnits();
    }

    public List<TimeUnit> findAll(int offset, int limit) {
        return this.model.findAllTimeUnits(offset, limit);
    }

    public int findCount() {
        return this.model.findTimeUnitCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
