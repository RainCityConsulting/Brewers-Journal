package com.rcc.brew.web;

import com.rcc.brew.bean.Time;
import com.rcc.brew.bean.TimeUnit;
import com.rcc.brew.bean.Weight;
import com.rcc.brew.bean.WeightUnit;
import com.rcc.brew.model.Model;

public class Format {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public String formatWeight(Weight w) {
        if (w == null) { return ""; }
        return String.format("%.2f %s", w.getValue(), w.getUnit().getName());
    }

    public String formatTime(Time t) {
        if (t == null) { return ""; }
        return String.format("%i %s", t.getValue(), t.getUnit().getName());
    }
}
