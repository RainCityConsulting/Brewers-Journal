package com.rcc.brew.web;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.TimeUnit;
import com.rcc.brew.bean.VolumeUnit;
import com.rcc.brew.bean.WeightUnit;
import com.rcc.brew.bean.Yeast;
import com.rcc.brew.web.bean.propertyeditor.AutoCompletePropertyEditor;
import com.rcc.brew.web.bean.propertyeditor.GrainNameResolver;
import com.rcc.brew.web.bean.propertyeditor.IdentifiableIdPropertyEditor;
import com.rcc.brew.model.GrainQuery;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class PropertyEditorRegistrar implements org.springframework.beans.PropertyEditorRegistrar {
    private GrainQuery grainQuery;
    private IdentifiableIdPropertyEditor timeUnitEditor;
    private IdentifiableIdPropertyEditor weightUnitEditor;
    private IdentifiableIdPropertyEditor volumeUnitEditor;
    private IdentifiableIdPropertyEditor hopsAdditionTypeEditor;
    private AutoCompletePropertyEditor<Hops> hopsEditor;
    private AutoCompletePropertyEditor<Yeast> yeastEditor;

    public void setYeastEditor(AutoCompletePropertyEditor<Yeast> yeastEditor) {
        this.yeastEditor = yeastEditor;
    }

    public void setHopsEditor(AutoCompletePropertyEditor<Hops> hopsEditor) {
        this.hopsEditor = hopsEditor;
    }

    public void setGrainQuery(GrainQuery grainQuery) { this.grainQuery = grainQuery; }

    public void setHopsAdditionTypeEditor(IdentifiableIdPropertyEditor hopsAdditionTypeEditor) {
        this.hopsAdditionTypeEditor = hopsAdditionTypeEditor;
    }

    public void setTimeUnitEditor(IdentifiableIdPropertyEditor timeUnitEditor) {
        this.timeUnitEditor = timeUnitEditor;
    }

    public void setVolumeUnitEditor(IdentifiableIdPropertyEditor volumeUnitEditor) {
        this.volumeUnitEditor = volumeUnitEditor;
    }

    public void setWeightUnitEditor(IdentifiableIdPropertyEditor weightUnitEditor) {
        this.weightUnitEditor = weightUnitEditor;
    }

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        AutoCompletePropertyEditor grainEditor = new AutoCompletePropertyEditor();
        grainEditor.setNameResolver(new GrainNameResolver());
        grainEditor.setQuery(this.grainQuery);

        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        registry.registerCustomEditor(Grain.class, grainEditor);
        registry.registerCustomEditor(Hops.class, this.hopsEditor);
        registry.registerCustomEditor(HopsAdditionType.class, this.hopsAdditionTypeEditor);
        registry.registerCustomEditor(VolumeUnit.class, this.volumeUnitEditor);
        registry.registerCustomEditor(WeightUnit.class, this.weightUnitEditor);
        registry.registerCustomEditor(TimeUnit.class, this.timeUnitEditor);
        registry.registerCustomEditor(Yeast.class, this.yeastEditor);
    }
}
