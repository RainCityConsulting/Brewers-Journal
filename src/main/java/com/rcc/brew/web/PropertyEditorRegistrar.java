package com.rcc.brew.web;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.WeightUnit;
import com.rcc.brew.web.bean.propertyeditor.AutoCompletePropertyEditor;
import com.rcc.brew.web.bean.propertyeditor.GrainNameResolver;
import com.rcc.brew.web.bean.propertyeditor.IdentifiableIdPropertyEditor;
import com.rcc.brew.model.GrainQuery;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class PropertyEditorRegistrar implements org.springframework.beans.PropertyEditorRegistrar {
    private GrainQuery grainQuery;
    private IdentifiableIdPropertyEditor weightUnitEditor;

    public void setGrainQuery(GrainQuery grainQuery) { this.grainQuery = grainQuery; }

    public void setWeightUnitEditor(IdentifiableIdPropertyEditor weightUnitEditor) {
        this.weightUnitEditor = weightUnitEditor;
    }

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        AutoCompletePropertyEditor grainEditor = new AutoCompletePropertyEditor();
        grainEditor.setNameResolver(new GrainNameResolver());
        grainEditor.setQuery(this.grainQuery);

        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        registry.registerCustomEditor(Grain.class, grainEditor);
        registry.registerCustomEditor(WeightUnit.class, weightUnitEditor);
    }
}
