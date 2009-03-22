package com.rcc.brew.web.bean.propertyeditor;

import java.beans.PropertyEditorSupport;

public class FloatPropertyEditor extends PropertyEditorSupport {

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0 || "0".equals(text)) {
            setValue(new Float(0f));
            return;
        }

        this.setValue(new Float(text));
    }

    public String getAsText() {
        Float f = (Float) this.getValue();
        if (f == null || f.floatValue() == 0f) { return ""; }
        return f.toString();
    }
}
