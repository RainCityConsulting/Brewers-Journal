package com.rcc.brew.service;

import com.rcc.brew.bean.Batch;
import com.rcc.brew.bean.Recipe;

public interface Service {
    public int createBatch(Batch b);
    public void updateBatch(Batch b);
    public int createRecipe(Recipe r);
    public void updateRecipe(Recipe r);
}
