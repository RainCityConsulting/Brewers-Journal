package com.rcc.brew.model;

import com.rcc.brew.bean.VolumeUnit;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class VolumeUnitQueryImpl extends ModelBase implements VolumeUnitQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public VolumeUnit findById(int id) {
        return this.model.findVolumeUnitById(id);
    }

    public List<VolumeUnit> findAll() {
        return this.model.findAllVolumeUnits();
    }

    public List<VolumeUnit> findAll(int offset, int limit) {
        return this.model.findAllVolumeUnits(offset, limit);
    }

    public int findCount() {
        return this.model.findVolumeUnitCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
