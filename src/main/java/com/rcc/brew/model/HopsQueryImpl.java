package com.rcc.brew.model;

import com.rcc.brew.bean.Hops;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class HopsQueryImpl extends ModelBase implements HopsQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Hops findById(int id) {
        return this.model.findHopsById(id);
    }

    public List<Hops> findAll() {
        return this.model.findAllHops();
    }

    public List<Hops> findAll(int offset, int limit) {
        return this.model.findAllHops(offset, limit);
    }

    public int findCount() {
        return this.model.findHopsCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
