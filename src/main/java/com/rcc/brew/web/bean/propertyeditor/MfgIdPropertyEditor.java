package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.brew.bean.Mfg;
import com.rcc.brew.model.Model;

import java.beans.PropertyEditorSupport;

public class MfgIdPropertyEditor extends PropertyEditorSupport {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0 || "0".equals(text)) {
            setValue(null);
            return;
        }

        Mfg m = null;
        try {
            int id = Integer.parseInt(text);
            m = this.model.findMfgById(id);
        } catch (NumberFormatException e) { ; }

        this.setValue(m);
    }

    public String getAsText() {
        Mfg m = (Mfg) this.getValue();
        if (m == null) { return "0"; }
        return String.valueOf(m.getId());
    }
}
