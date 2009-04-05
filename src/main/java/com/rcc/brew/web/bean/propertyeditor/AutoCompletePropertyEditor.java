package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.beans.Identifiable;
import com.rcc.model.BeanQuery;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoCompletePropertyEditor<T extends Identifiable> extends PropertyEditorSupport {
    private static Pattern acIdPattern = Pattern.compile("^.*\\[id: (\\d+)\\]$");

    public static interface NameResolver<T extends Identifiable> {
        public String resolveName(T t);
    }

    private NameResolver<T> nameResolver;

    public void setNameResolver(NameResolver<T> nameResolver) {
        this.nameResolver = nameResolver;
    }

    private BeanQuery<T> query;

    public void setQuery(BeanQuery<T> query) {
        this.query = query;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0) {
            setValue(null);
            return;
        }

        int id = this.getAutoCompleteId(text, 0);

        if (id == 0) {
            this.setValue(null);
            return;
        }

        Identifiable t = this.query.findById(id);

        this.setValue(t);
    }

    public String getAsText() {
        T t = (T) this.getValue();
        if (t == null) { return ""; }
        String name = this.nameResolver.resolveName(t);

        if (t.getId() == 0) {
            return name;
        }

        return String.format("%s [id: %d]", name, t.getId());
    }

    private int getAutoCompleteId(String s, int fallback) {
        Matcher matcher = acIdPattern.matcher(s);
        if (!matcher.matches()) {
            return fallback;
        }
        return Integer.parseInt(matcher.group(1));
    }
}
