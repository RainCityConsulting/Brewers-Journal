package com.rcc.brew.bean;

public class Weight extends com.rcc.brew.bean.gen.Weight {
    public Weight() { ; }

    public Weight(WeightUnit u) {
        this.unit = u;
    }

    public double gramWeight() {
        if (this.unit == null) {
            throw new RuntimeException("Cannot calculate gram weight with a null WeightUnit");
        }
        return this.value * this.unit.getGramConversion();
    }

    public double convert(WeightUnit u) {
        if (this.unit == null) {
            throw new RuntimeException("Cannot convert weight with a null WeightUnit");
        }

        if (this.unit == u) {
            return this.value;
        }

        double grams = this.gramWeight();

        return grams / u.getGramConversion();
    }
}
