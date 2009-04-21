package com.rcc.brew.service;

import com.rcc.brew.bean.Recipe;

public interface Service {
    public int createRecipe(Recipe r);
    public void updateRecipe(Recipe r);
}
