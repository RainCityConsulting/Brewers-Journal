package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.brew.bean.Yeast;

public class YeastNameResolver implements AutoCompletePropertyEditor.NameResolver<Yeast> {
    public String resolveName(Yeast yeast) {
        if (yeast == null) {
            return "";
        }

        if (yeast.hasMfg()) {
            return String.format("%s (%s)", yeast.getName(), yeast.getMfg().getName());
        }

        return yeast.getName();
    }
}
