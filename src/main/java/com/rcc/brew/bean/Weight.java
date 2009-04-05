package com.rcc.brew.bean;

public class Weight extends com.rcc.brew.bean.gen.Weight {
    public Weight() { ; }

    public Weight(WeightUnit u) {
        this.unit = u;
    }

    public int getGramWeight() {
        if (this.unit == null) {
            throw new RuntimeException("Cannot calculate gram weight with a null WeightUnit");
        }
        return (int) Math.round(this.value * this.unit.getConversion());
    }

    public double convert(WeightUnit u) {
        if (this.unit == null) {
            throw new RuntimeException("Cannot convert weight with a null WeightUnit");
        }

        if (this.unit.getId() == u.getId()) {
            return this.value;
        }

        double val = this.value * this.unit.getConversion();

        return val / u.getConversion();
    }
}
