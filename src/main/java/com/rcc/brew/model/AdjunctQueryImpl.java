package com.rcc.brew.model;

import com.rcc.brew.bean.Adjunct;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class AdjunctQueryImpl extends ModelBase implements AdjunctQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Adjunct findById(int id) {
        return this.model.findAdjunctById(id);
    }

    public List<Adjunct> findAll() {
        return this.model.findAllAdjuncts();
    }

    public List<Adjunct> findAll(int offset, int limit) {
        return this.model.findAllAdjuncts(offset, limit);
    }

    public int findCount() {
        return this.model.findAdjunctCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
