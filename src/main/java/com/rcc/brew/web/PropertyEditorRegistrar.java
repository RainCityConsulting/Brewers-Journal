package com.rcc.brew.web;

import com.rcc.brew.bean.Adjunct;
import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GravityReadingType;
import com.rcc.brew.bean.GravityUnit;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.MashStepType;
import com.rcc.brew.bean.TempUnit;
import com.rcc.brew.bean.TimeUnit;
import com.rcc.brew.bean.VolumeUnit;
import com.rcc.brew.bean.Yeast;
import com.rcc.brew.web.bean.propertyeditor.AutoCompletePropertyEditor;
import com.rcc.brew.web.bean.propertyeditor.GrainNameResolver;
import com.rcc.brew.web.bean.propertyeditor.IdentifiableIdPropertyEditor;
import com.rcc.brew.model.GrainQuery;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PropertyEditorRegistrar implements org.springframework.beans.PropertyEditorRegistrar {
    private static final DateFormat defaultDateFormat = new SimpleDateFormat("MMM d, yyyy");

    private GrainQuery grainQuery;
    private IdentifiableIdPropertyEditor gravityUnitEditor;
    private IdentifiableIdPropertyEditor gravityReadingTypeEditor;
    private IdentifiableIdPropertyEditor tempUnitEditor;
    private IdentifiableIdPropertyEditor timeUnitEditor;
    private IdentifiableIdPropertyEditor volumeUnitEditor;
    private IdentifiableIdPropertyEditor hopsAdditionTypeEditor;
    private IdentifiableIdPropertyEditor mashStepTypeEditor;
    private AutoCompletePropertyEditor<Adjunct> adjunctEditor;
    private AutoCompletePropertyEditor<Hops> hopsEditor;
    private AutoCompletePropertyEditor<Yeast> yeastEditor;

    public void setYeastEditor(AutoCompletePropertyEditor<Yeast> yeastEditor) {
        this.yeastEditor = yeastEditor;
    }

    public void setAdjunctEditor(AutoCompletePropertyEditor<Adjunct> adjunctEditor) {
        this.adjunctEditor = adjunctEditor;
    }

    public void setHopsEditor(AutoCompletePropertyEditor<Hops> hopsEditor) {
        this.hopsEditor = hopsEditor;
    }

    public void setGrainQuery(GrainQuery grainQuery) { this.grainQuery = grainQuery; }

    public void setHopsAdditionTypeEditor(IdentifiableIdPropertyEditor hopsAdditionTypeEditor) {
        this.hopsAdditionTypeEditor = hopsAdditionTypeEditor;
    }

    public void setGravityReadingTypeEditor(IdentifiableIdPropertyEditor gravityReadingTypeEditor) {
        this.gravityReadingTypeEditor = gravityReadingTypeEditor;
    }

    public void setGravityUnitEditor(IdentifiableIdPropertyEditor gravityUnitEditor) {
        this.gravityUnitEditor = gravityUnitEditor;
    }

    public void setTempUnitEditor(IdentifiableIdPropertyEditor tempUnitEditor) {
        this.tempUnitEditor = tempUnitEditor;
    }

    public void setTimeUnitEditor(IdentifiableIdPropertyEditor timeUnitEditor) {
        this.timeUnitEditor = timeUnitEditor;
    }

    public void setVolumeUnitEditor(IdentifiableIdPropertyEditor volumeUnitEditor) {
        this.volumeUnitEditor = volumeUnitEditor;
    }

    public void setMashStepTypeEditor(IdentifiableIdPropertyEditor mashStepTypeEditor) {
        this.mashStepTypeEditor = mashStepTypeEditor;
    }

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        AutoCompletePropertyEditor grainEditor = new AutoCompletePropertyEditor();
        grainEditor.setNameResolver(new GrainNameResolver());
        grainEditor.setQuery(this.grainQuery);

        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        registry.registerCustomEditor(Adjunct.class, adjunctEditor);
        registry.registerCustomEditor(Grain.class, grainEditor);
        registry.registerCustomEditor(Hops.class, this.hopsEditor);
        registry.registerCustomEditor(HopsAdditionType.class, this.hopsAdditionTypeEditor);
        registry.registerCustomEditor(VolumeUnit.class, this.volumeUnitEditor);
        registry.registerCustomEditor(MashStepType.class, this.mashStepTypeEditor);
        registry.registerCustomEditor(TempUnit.class, this.tempUnitEditor);
        registry.registerCustomEditor(GravityUnit.class, this.gravityUnitEditor);
        registry.registerCustomEditor(GravityReadingType.class, this.gravityReadingTypeEditor);
        registry.registerCustomEditor(TimeUnit.class, this.timeUnitEditor);
        registry.registerCustomEditor(Yeast.class, this.yeastEditor);

        registry.registerCustomEditor(Date.class,
                new CustomDateEditor(this.defaultDateFormat, true));
    }
}
