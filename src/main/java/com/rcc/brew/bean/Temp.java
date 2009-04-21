package com.rcc.brew.bean;

public class Temp extends com.rcc.brew.bean.gen.Temp {
    public Temp() { ; }

    public Temp(TempUnit u) {
        this.unit = u;
    }

    public double convert(TempUnit u) {
        if (this.unit == null) {
            throw new RuntimeException("Cannot convert weight with a null TempUnit");
        }

        if (this.unit.getId() == u.getId()) {
            return this.value;
        }

        if ("F".equals(this.unit.getName())) {
            return (value - 32d) * 5d / 9d;
        } else if ("C".equals(this.unit.getName())) {
            return (this.value * 9d / 5d) + 32;
        } else {
            throw new RuntimeException("Unknown temperature unit: " + this.unit.getName());
        }
    }
}
