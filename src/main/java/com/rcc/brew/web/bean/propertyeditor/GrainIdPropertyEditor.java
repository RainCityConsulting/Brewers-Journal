package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.model.Model;

import java.beans.PropertyEditorSupport;

public class GrainIdPropertyEditor extends PropertyEditorSupport {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0 || "0".equals(text)) {
            setValue(null);
            return;
        }

        Grain g = null;
        try {
            int id = Integer.parseInt(text);
            g = this.model.findGrainById(id);
        } catch (NumberFormatException e) { ; }

        this.setValue(g);
    }

    public String getAsText() {
        Grain g = (Grain) this.getValue();
        if (g == null) { return "0"; }
        return String.valueOf(g.getId());
    }
}
