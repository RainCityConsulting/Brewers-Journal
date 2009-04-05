package com.rcc.cfr.web.bean.propertyeditor;

import com.rcc.beans.Identifiable;

import java.beans.PropertyEditorSupport;

public class IdentifiablePropertyEditor<T extends Identifiable> extends PropertyEditorSupport {
    private Class<T> klass;

    public void setClass(Class<T> klass) {
        this.klass = klass;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0) {
            setValue(null);
            return;
        }

        T t = null;
        try {
            int id = Integer.parseInt(text);
            t = this.klass.newInstance();
            t.setId(id);
        } catch (NumberFormatException e) { ; }
        catch (Exception e) { throw new RuntimeException(e); }

        setValue(t);
    }

    public String getAsText() {
        T t = (T) this.getValue();
        if (t == null) { return "0"; }
        return String.valueOf(t.getId());
    }
}
