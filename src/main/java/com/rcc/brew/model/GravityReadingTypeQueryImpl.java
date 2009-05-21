package com.rcc.brew.model;

import com.rcc.brew.bean.GravityReadingType;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class GravityReadingTypeQueryImpl extends ModelBase implements GravityReadingTypeQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public GravityReadingType findById(int id) {
        return this.model.findGravityReadingTypeById(id);
    }

    public List<GravityReadingType> findAll() {
        return this.model.findAllGravityReadingTypes();
    }

    public List<GravityReadingType> findAll(int offset, int limit) {
        return this.model.findAllGravityReadingTypes(offset, limit);
    }

    public int findCount() {
        return this.model.findGravityReadingTypeCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
