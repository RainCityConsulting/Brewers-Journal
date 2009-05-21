package com.rcc.brew.service;

import com.rcc.brew.bean.AdjunctInstance;
import com.rcc.brew.bean.Batch;
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

    public int createBatch(Batch b) {
        int id = this.model.createBatch(b);

        for (GrainInstance g : b.getGrains()) {
            this.model.createBatchGrain(id, g);
        }

        for (HopsInstance h : b.getHops()) {
            this.model.createBatchHops(id, h);
        }

        for (YeastInstance y : b.getYeast()) {
            this.model.createBatchYeast(id, y);
        }

        for (AdjunctInstance a : b.getAdjuncts()) {
            this.model.createBatchAdjunct(id, a);
        }

        int i = 0;
        for (MashStep m : b.getMash()) {
            m.setOrdinal(i);
            this.model.createBatchMashStep(id, m);
            i++;
        }

        if (b.hasNotes()) {
            for (Note n : b.getNotes()) {
                n.setObjectType("batch");
                n.setObjectId(id);
                this.model.createNote(n);
            }
        }

        return id;
    }

    public void updateBatch(Batch b) {
        this.model.updateBatch(b);
        this.model.deleteBatchGrainsByBatch(b.getId());
        this.model.deleteBatchHopsByBatch(b.getId());
        this.model.deleteBatchYeastByBatch(b.getId());
        this.model.deleteBatchAdjunctsByBatch(b.getId());
        this.model.deleteBatchMashStepsByBatch(b.getId());

        this.model.deleteNotesByObjectTypeAndObject("batch", b.getId());

        for (GrainInstance g : b.getGrains()) {
            this.model.createBatchGrain(b.getId(), g);
        }

        for (HopsInstance h : b.getHops()) {
            this.model.createBatchHops(b.getId(), h);
        }

        for (YeastInstance y : b.getYeast()) {
            this.model.createBatchYeast(b.getId(), y);
        }

        for (AdjunctInstance a : b.getAdjuncts()) {
            this.model.createBatchAdjunct(b.getId(), a);
        }

        int i = 0;
        for (MashStep m : b.getMash()) {
            m.setOrdinal(i);
            this.model.createBatchMashStep(b.getId(), m);
            i++;
        }

        if (b.hasNotes()) {
            for (Note n : b.getNotes()) {
                n.setObjectType("batch");
                n.setObjectId(b.getId());
                this.model.createNote(n);
            }
        }
    }

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

        for (AdjunctInstance a : r.getAdjuncts()) {
            this.model.createRecipeAdjunct(id, a);
        }

        int i = 0;
        for (MashStep m : r.getMash()) {
            m.setOrdinal(i);
            this.model.createRecipeMashStep(id, m);
            i++;
        }

        if (r.hasNotes()) {
            for (Note n : r.getNotes()) {
                n.setObjectType("recipe");
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
        this.model.deleteRecipeAdjunctsByRecipe(r.getId());
        this.model.deleteRecipeMashStepsByRecipe(r.getId());

        this.model.deleteNotesByObjectTypeAndObject("recipe", r.getId());

        for (GrainInstance g : r.getGrains()) {
            this.model.createRecipeGrain(r.getId(), g);
        }

        for (HopsInstance h : r.getHops()) {
            this.model.createRecipeHops(r.getId(), h);
        }

        for (YeastInstance y : r.getYeast()) {
            this.model.createRecipeYeast(r.getId(), y);
        }

        for (AdjunctInstance a : r.getAdjuncts()) {
            this.model.createRecipeAdjunct(r.getId(), a);
        }

        int i = 0;
        for (MashStep m : r.getMash()) {
            m.setOrdinal(i);
            this.model.createRecipeMashStep(r.getId(), m);
            i++;
        }

        if (r.hasNotes()) {
            for (Note n : r.getNotes()) {
                n.setObjectType("recipe");
                n.setObjectId(r.getId());
                this.model.createNote(n);
            }
        }
    }
}
