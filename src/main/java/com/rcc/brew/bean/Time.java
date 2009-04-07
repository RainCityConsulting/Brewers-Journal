package com.rcc.brew.bean;

public class Time extends com.rcc.brew.bean.gen.Time {
    public Time() { ; }

    public Time(TimeUnit u) {
        this.unit = u;
    }

    public double convert(TimeUnit u) {
        if (this.unit == null) {
            throw new RuntimeException("Cannot convert weight with a null TimeUnit");
        }

        if (this.unit.getId() == u.getId()) {
            return this.value;
        }

        double val = this.value * this.unit.getConversion();

        return val / u.getConversion();
    }
}
