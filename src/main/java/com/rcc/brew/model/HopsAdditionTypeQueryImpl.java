package com.rcc.brew.model;

import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class HopsAdditionTypeQueryImpl extends ModelBase implements HopsAdditionTypeQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public HopsAdditionType findById(int id) {
        return this.model.findHopsAdditionTypeById(id);
    }

    public List<HopsAdditionType> findAll() {
        return this.model.findAllHopsAdditionTypes();
    }

    public List<HopsAdditionType> findAll(int offset, int limit) {
        return this.model.findAllHopsAdditionTypes(offset, limit);
    }

    public int findCount() {
        return this.model.findHopsAdditionTypeCount();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
