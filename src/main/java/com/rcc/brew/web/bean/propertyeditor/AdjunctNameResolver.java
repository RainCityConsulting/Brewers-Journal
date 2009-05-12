package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.brew.bean.Adjunct;

public class AdjunctNameResolver implements AutoCompletePropertyEditor.NameResolver<Adjunct> {
    public String resolveName(Adjunct adjunct) {
        if (adjunct == null) {
            return "";
        }

        if (adjunct.hasMfg()) {
            return String.format("%s (%s)", adjunct.getName(), adjunct.getMfg().getName());
        }

        return adjunct.getName();
    }
}
