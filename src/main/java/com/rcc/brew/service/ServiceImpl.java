package com.rcc.brew.service;

import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.HopsInstance;
import com.rcc.brew.bean.MashStep;
import com.rcc.brew.bean.Note;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.YeastInstance;
import com.rcc.brew.model.Model;

public class ServiceImpl implements Service {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public int createRecipe(Recipe r) {
        int id = this.model.createRecipe(r);

        for (GrainInstance g : r.getGrains()) {
            this.model.createRecipeGrain(id, g);
        }

        for (HopsInstance h : r.getHops()) {
            this.model.createRecipeHops(id, h);
        }

        for (YeastInstance y : r.getYeast()) {
            this.model.createRecipeYeast(id, y);
        }

        int i = 0;
        for (MashStep m : r.getMash()) {
            m.setOrdinal(i);
            this.model.createRecipeMashStep(id, m);
            i++;
        }

        if (r.hasNotes()) {
            int recipeObjectTypeId = this.model.findObjectTypeIdByName("recipe");
            for (Note n : r.getNotes()) {
                n.setObjectTypeId(recipeObjectTypeId);
                n.setObjectId(id);
                this.model.createNote(n);
            }
        }

        return id;
    }

    public void updateRecipe(Recipe r) {
        this.model.updateRecipe(r);
        this.model.deleteRecipeGrainsByRecipe(r.getId());
        this.model.deleteRecipeHopsByRecipe(r.getId());
        this.model.deleteRecipeYeastByRecipe(r.getId());
        this.model.deleteRecipeMashStepsByRecipe(r.getId());

        int recipeObjectTypeId = this.model.findObjectTypeIdByName("recipe");
        this.model.deleteNotesByObjectTypeAndObject(recipeObjectTypeId, r.getId());

        for (GrainInstance g : r.getGrains()) {
            this.model.createRecipeGrain(r.getId(), g);
        }

        for (HopsInstance h : r.getHops()) {
            this.model.createRecipeHops(r.getId(), h);
        }

        for (YeastInstance y : r.getYeast()) {
            this.model.createRecipeYeast(r.getId(), y);
        }

        int i = 0;
        for (MashStep m : r.getMash()) {
            m.setOrdinal(i);
            this.model.createRecipeMashStep(r.getId(), m);
            i++;
        }

        if (r.hasNotes()) {
            for (Note n : r.getNotes()) {
                n.setObjectTypeId(recipeObjectTypeId);
                n.setObjectId(r.getId());
                this.model.createNote(n);
            }
        }
    }
}
