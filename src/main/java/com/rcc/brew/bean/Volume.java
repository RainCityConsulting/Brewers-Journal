package com.rcc.brew.bean;

public class Volume extends com.rcc.brew.bean.gen.Volume {
    public Volume() { ; }

    public Volume(VolumeUnit u) {
        this.unit = u;
    }

    public int mlVolume() {
        if (this.unit == null) {
            throw new RuntimeException("Cannot calculate ml volume with a null VolumeUnit");
        }
        return (int) Math.round(this.value * this.unit.getConversion());
    }

    public double convert(VolumeUnit u) {
        if (this.unit == null) {
            throw new RuntimeException("Cannot convert weight with a null VolumeUnit");
        }

        if (this.unit.getId() == u.getId()) {
            return this.value;
        }

        double val = this.value * this.unit.getConversion();

        return val / u.getConversion();
    }
}
