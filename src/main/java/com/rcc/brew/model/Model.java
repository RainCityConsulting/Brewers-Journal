package com.rcc.brew.model;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.User;
import com.rcc.brew.bean.VolumeUnit;
import com.rcc.brew.bean.WeightUnit;

import java.util.List;

public interface Model {
    /* USER */
    public int createUser(User u);
    public void updateUser(User u);
    public User findUserById(int id);
    public User findUserByName(String name);
    public User findUserByMail(String mail);
    /* END USER */

    /* MFG */
    public int createMfg(Mfg m);
    public void updateMfg(Mfg m);
    public Mfg findMfgById(int id);
    public Mfg findMfgByName(String name);
    public List<Mfg> findAllMfgs();
    /* END MFG */

    /* GRAIN */
    public int createGrain(Grain g);
    public void updateGrain(Grain g);
    public Grain findGrainById(int id);
    public Grain findGrainByName(String name);
    public List<Grain> findAllGrains();
    /* END GRAIN */

    /* WEIGHT */
    public List<WeightUnit> findAllWeightUnits();
    /* END WEIGHT */

    /* VOLUME */
    public List<VolumeUnit> findAllVolumeUnits();
    /* END VOLUME */

    /* RECIPE */
    public int createRecipe(Recipe r);
    public void updateRecipe(Recipe r);
    public Recipe findRecipeById(int id);
    public List<Recipe> findRecipesByUser(int id);
    public int createRecipeGrain(int recipeId, GrainInstance g);
    /* END RECIPE */
}
