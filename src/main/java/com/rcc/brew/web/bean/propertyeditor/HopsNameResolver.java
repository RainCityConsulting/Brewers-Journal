package com.rcc.brew.web.bean.propertyeditor;

import com.rcc.brew.bean.Hops;

public class HopsNameResolver implements AutoCompletePropertyEditor.NameResolver<Hops> {
    public String resolveName(Hops hops) {
        if (hops == null) {
            return "";
        }

        if (hops.hasMfg()) {
            return String.format("%s (%s)", hops.getName(), hops.getMfg().getName());
        }

        return hops.getName();
    }
}
