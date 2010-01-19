package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Batch;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.model.Model;
import com.rcc.brew.service.Service;

import com.rcc.web.FlashUtils;
import com.rcc.web.HistoryUtils;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;

public class RecipeController extends MultiActionController {
    private Model model;
    private Service service;

    public void setModel(Model model) { this.model = model; }
    public void setService(Service service) { this.service = service; }

    public ModelAndView recipeToBatch(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        int recipeId = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);
        Recipe recipe = this.model.findRecipeById(recipeId);

        Batch batch = new Batch();
        batch.setDate(new Date());
        batch.setName(recipe.getName());
        batch.setGrains(recipe.getGrains());
        batch.setHops(recipe.getHops());
        batch.setBoilTime(recipe.getBoilTime());
        batch.setVolume(recipe.getVolume());
        batch.setYeast(recipe.getYeast());
        batch.setMash(recipe.getMash());
        batch.setAdjuncts(recipe.getAdjuncts());

        int id = this.service.createBatch(batch);

        return new ModelAndView("redirect:/batch.s?id=" + id);
    }
}
