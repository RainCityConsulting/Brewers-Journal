package com.rcc.brew.model;

import com.rcc.brew.bean.Yeast;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class YeastQueryImpl extends ModelBase implements YeastQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public Yeast findById(int id) {
        return this.model.findYeastById(id);
    }

    public List<Yeast> findAll() {
        return this.model.findAllYeast();
    }

    public List<Yeast> findAll(int offset, int limit) {
        return this.model.findAllYeast(offset, limit);
    }

    public int findCount() {
        return this.model.findYeastCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
