package com.rcc.brew.web;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class PropertyEditorRegistrar implements org.springframework.beans.PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
