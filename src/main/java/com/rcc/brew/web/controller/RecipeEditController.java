package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.HopsInstance;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.Time;
import com.rcc.brew.bean.TimeUnit;
import com.rcc.brew.bean.User;
import com.rcc.brew.bean.Weight;
import com.rcc.brew.bean.WeightUnit;
import com.rcc.brew.model.Model;
import com.rcc.brew.web.bean.propertyeditor.FloatPropertyEditor;
import com.rcc.brew.web.bean.propertyeditor.GrainIdPropertyEditor;

import com.rcc.beans.Identifiable;
import com.rcc.web.FlashUtils;
import com.rcc.web.controller.AbstractEditController;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecipeEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(RecipeEditController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected Identifiable formNewBackingObject() throws Exception {
        Recipe recipe = new Recipe();

        List<GrainInstance> grains = new ArrayList<GrainInstance>();
        for (int i = 0; i < 8; i++) {
            GrainInstance gi = new GrainInstance();
            gi.setWeight(new Weight(new WeightUnit()));
            grains.add(gi);
        }
        recipe.setGrains(grains);

        List<HopsInstance> hops = new ArrayList<HopsInstance>();
        for (int i = 0; i < 8; i++) {
            HopsInstance hi = new HopsInstance();
            hi.setWeight(new Weight(new WeightUnit()));
            hi.setTime(new Time(new TimeUnit()));
            hi.setAdditionType(new HopsAdditionType());
            hops.add(hi);
        }
        recipe.setHops(hops);

        return recipe;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findRecipeById(id);
    }

    protected void referenceData(Map map) {
        map.put("grains", this.model.findAllGrains());
        map.put("weightUnits", this.model.findAllWeightUnits());
        map.put("timeUnits", this.model.findAllTimeUnits());
        map.put("hats", this.model.findAllHopsAdditionTypes());
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
        throws Exception
    {
        //GrainIdPropertyEditor ed = new GrainIdPropertyEditor();
        //ed.setModel(this.model);
        //binder.registerCustomEditor(Grain.class, ed);
        //binder.registerCustomEditor(Float.class, new FloatPropertyEditor());
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Recipe recipe = (Recipe) command;

        int id = this.model.createRecipe(recipe);

        log.debug("GrainInstance count: " + recipe.getGrains().size());
        for (GrainInstance g : recipe.getGrains()) {
            log.debug("GrainInstance: " + g);
            if (g.hasGrain()) {
                this.model.createRecipeGrain(id, g);
            }
        }

        for (HopsInstance h : recipe.getHops()) {
            if (h.hasHops()) {
                this.model.createRecipeHops(id, h);
            }
        }

        FlashUtils.messageCode("recipe.create.success", request, recipe.getName());

        return new ModelAndView("redirect:/recipe.s?id=" + id);
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Recipe recipe = (Recipe) command;
        this.model.updateRecipe(recipe);
        this.model.deleteRecipeGrainsByRecipe(recipe.getId());
        this.model.deleteRecipeHopsByRecipe(recipe.getId());

        for (GrainInstance g : recipe.getGrains()) {
            if (g.hasGrain()) {
                this.model.createRecipeGrain(recipe.getId(), g);
            }
        }

        for (HopsInstance h : recipe.getHops()) {
            if (h.hasHops()) {
                this.model.createRecipeHops(recipe.getId(), h);
            }
        }

        FlashUtils.messageCode("recipe.update.success", request, recipe.getName());

        return new ModelAndView("redirect:/recipe.s?id=" + recipe.getId());
    }
}
