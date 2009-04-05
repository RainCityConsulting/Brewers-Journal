package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.brew.bean.Grain;

public class GrainNameResolver implements AutoCompletePropertyEditor.NameResolver<Grain> {
    public String resolveName(Grain grain) {
        if (grain == null) {
            return "";
        }

        if (grain.hasMfg()) {
            return String.format("%s (%s)", grain.getName(), grain.getMfg().getName());
        }

        return grain.getName();
    }
}
