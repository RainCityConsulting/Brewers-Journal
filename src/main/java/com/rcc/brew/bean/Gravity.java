package com.rcc.brew.bean;

/**
 * Reference: http://www.primetab.com/formulas.html
 */
public class Gravity extends com.rcc.brew.bean.gen.Gravity {
    public Gravity() { ; }

    public Gravity(Gravity g) {
        this.value = g.value;
        this.unit = new GravityUnit(g.unit);
    }

    public Gravity(GravityUnit u) {
        this.unit = u;
    }

    public Gravity(Double value, GravityUnit u) {
        this.value = value;
        this.unit = u;
    }
}
