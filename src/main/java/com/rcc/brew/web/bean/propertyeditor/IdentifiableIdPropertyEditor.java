package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.beans.Identifiable;
import com.rcc.model.BeanQuery;

import java.beans.PropertyEditorSupport;

public class IdentifiableIdPropertyEditor<T extends Identifiable> extends PropertyEditorSupport {
    private BeanQuery beanQuery;

    public void setBeanQuery(BeanQuery beanQuery) { this.beanQuery = beanQuery; }

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0 || "0".equals(text)) {
            setValue(null);
            return;
        }

        Identifiable t = null;
        try {
            int id = Integer.parseInt(text);
            t = this.beanQuery.findById(id);
        } catch (NumberFormatException e) { ; }

        this.setValue(t);
    }

    public String getAsText() {
        Identifiable t = (Identifiable) this.getValue();
        if (t == null) { return "0"; }
        return String.valueOf(t.getId());
    }
}
