package com.rcc.brew.model;

import com.rcc.brew.bean.MashStepType;
import com.rcc.model.BeanQuery;
import com.rcc.model.ModelBase;

import java.util.List;

public class MashStepTypeQueryImpl extends ModelBase implements MashStepTypeQuery {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    /* IMPLEMENTATION OF com.rcc.model.BeanQuery */
    public MashStepType findById(int id) {
        return this.model.findMashStepTypeById(id);
    }

    public List<MashStepType> findAll() {
        return this.model.findAllMashStepTypes();
    }

    public List<MashStepType> findAll(int offset, int limit) {
        return this.model.findAllMashStepTypes(offset, limit);
    }

    public int findCount() {
        throw new UnsupportedOperationException();
    }
    /* END IMPLEMENTATION OF com.rcc.model.BeanQuery */
}
