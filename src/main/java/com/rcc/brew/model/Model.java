package com.rcc.brew.model;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.HopsInstance;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.TimeUnit;
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
    public List<Grain> findAllGrains(int offset, int limit);
    public int findGrainCount();
    /* END GRAIN */

    /* HOPS */
    public int createHops(Hops h);
    public void updateHops(Hops h);
    public Hops findHopsById(int id);
    public Hops findHopsByName(String name);
    public List<Hops> findAllHops();
    public List<Hops> findAllHops(int offset, int limit);
    public int findHopsCount();
    /* END HOPS */

    /* WEIGHT */
    public WeightUnit findWeightUnitById(int id);
    public WeightUnit findWeightUnitByName(String name);
    public List<WeightUnit> findAllWeightUnits();
    public List<WeightUnit> findAllWeightUnits(int offset, int limit);
    public int findWeightUnitCount();
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
    public int deleteRecipeGrainsByRecipe(int id);
    /* END RECIPE */

    /* HOPS ADDITION TYPE */
    public int createHopsAdditionType(HopsAdditionType hat);
    public void updateHopsAdditionType(HopsAdditionType hat);
    public HopsAdditionType findHopsAdditionTypeById(int id);
    public HopsAdditionType findHopsAdditionTypeByName(String name);
    public List<HopsAdditionType> findAllHopsAdditionTypes();
    public List<HopsAdditionType> findAllHopsAdditionTypes(int offset, int limit);
    public int findHopsAdditionTypeCount();
    /* END HOPS ADDITION TYPE */

    /* RECIPE HOPS */
    public int createRecipeHops(int recipeId, HopsInstance h);
    public int deleteRecipeHopsByRecipe(int id);
    /* END RECIPE HOPS */

    /* TIME */
    public TimeUnit findTimeUnitById(int id);
    public TimeUnit findTimeUnitByName(String name);
    public List<TimeUnit> findAllTimeUnits();
    public List<TimeUnit> findAllTimeUnits(int offset, int limit);
    public int findTimeUnitCount();
    /* END TIME */
}
