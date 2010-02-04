package com.rcc.brew.bean;

public enum WeightUnit {
    LB("Pounds", "lb", 453.59237f),
    KG("Killograms", "kg", 1000),
    GR("Grams", "g", 1f),
    OZ("Ounces", "oz", 28.349523f);

    private double gramConversion;
    private String name;
    private String shortName;

    private WeightUnit(String name, String shortName, double gramConversion) {
        this.name = name;
        this.shortName = shortName;
        this.gramConversion = gramConversion;
    }

    public double getGramConversion() { return this.gramConversion; }
    public String getName() { return this.name; }
    public String getShortName() { return this.shortName; }
}
