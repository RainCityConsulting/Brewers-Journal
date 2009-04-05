package com.rcc.brew.model;

import com.rcc.brew.bean.Grain;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class GrainQueryImpl extends ModelBase implements GrainQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Grain findById(int id) {
        return this.model.findGrainById(id);
    }

    public List<Grain> findAll() {
        return this.model.findAllGrains();
    }

    public List<Grain> findAll(int offset, int limit) {
        return this.model.findAllGrains(offset, limit);
    }

    public int findCount() {
        return this.model.findGrainCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
