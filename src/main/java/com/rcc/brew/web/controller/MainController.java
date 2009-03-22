package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.User;
import com.rcc.brew.model.Model;
import com.rcc.brew.util.ContextUtils;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

public class MainController extends MultiActionController {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public ModelAndView view(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        mav.addObject("content", "Index");

        return mav;
    }

    public ModelAndView recipe(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        User user = ContextUtils.getRequestContext(false).getUser();

        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);

        if (id == 0) {
            List<Recipe> recipes = this.model.findRecipesByUser(user.getId());
            mav.addObject("content", "RecipeList");
            mav.addObject("recipes", recipes);
        } else {
            Recipe recipe = this.model.findRecipeById(id);

            mav.addObject("content", "Recipe");
            mav.addObject("recipe", recipe);
        }

        return mav;
    }
}
