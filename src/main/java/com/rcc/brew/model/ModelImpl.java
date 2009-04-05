package com.rcc.brew.model;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.User;
import com.rcc.brew.bean.VolumeUnit;
import com.rcc.brew.bean.WeightUnit;

import com.rcc.model.ModelBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class ModelImpl extends ModelBase implements Model {

    /* USER */

    public int createUser(User u) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertUser", u);
        return id.intValue();
    }

    public void updateUser(User u) {
        this.getSqlMapClientTemplate().update("updateUser", u);
    }

    public User findUserById(int id) {
        User u = (User) this.getSqlMapClientTemplate().queryForObject("findUserById", id);
        if (u == null) { throw new ObjectNotFoundException("User ID: " + id); }
        return u;
    }

    public User findUserByName(String name) {
        return (User) this.getSqlMapClientTemplate().queryForObject("findUserByName", name);
    }

    public User findUserByMail(String mail) {
        return (User) this.getSqlMapClientTemplate().queryForObject("findUserByMail", mail);
    }

    /* END USER */

    /* MFG */
    public int createMfg(Mfg m) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertMfg", m);
        return id.intValue();
    }

    public void updateMfg(Mfg m) {
        this.getSqlMapClientTemplate().update("updateMfg", m);
    }

    public Mfg findMfgById(int id) {
        Mfg m = (Mfg) this.getSqlMapClientTemplate().queryForObject("findMfgById", id);
        if (m == null) { throw new ObjectNotFoundException("Mfg ID: " + id); }
        return m;
    }

    public Mfg findMfgByName(String name) {
        return (Mfg) this.getSqlMapClientTemplate().queryForObject("findMfgByName", name);
    }

    public List<Mfg> findAllMfgs() {
        return (List<Mfg>) this.getSqlMapClientTemplate().queryForList("findAllMfgs");
    }
    /* END MFG */

    /* GRAIN */
    public int createGrain(Grain g) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertGrain", g);
        return id.intValue();
    }

    public void updateGrain(Grain g) {
        this.getSqlMapClientTemplate().update("updateGrain", g);
    }

    public Grain findGrainById(int id) {
        Grain g = (Grain) this.getSqlMapClientTemplate().queryForObject("findGrainById", id);
        if (g == null) { throw new ObjectNotFoundException("Grain ID: " + id); }
        return g;
    }

    public Grain findGrainByName(String name) {
        return (Grain) this.getSqlMapClientTemplate().queryForObject("findGrainByName", name);
    }

    public List<Grain> findAllGrains() {
        return (List<Grain>) this.getSqlMapClientTemplate().queryForList("findAllGrains");
    }

    public List<Grain> findAllGrains(int offset, int limit) {
        return (List<Grain>) this.getSqlMapClientTemplate().queryForList(
                "findAllGrains", offset, limit);
    }

    public int findGrainCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findGrainCount");
        
    }
    /* END GRAIN */

    /* WEIGHT */
    public WeightUnit findWeightUnitById(int id) {
        return (WeightUnit) this.getSqlMapClientTemplate().queryForObject("findWeightUnitById", id);
    }

    public WeightUnit findWeightUnitByName(String name) {
        return (WeightUnit) this.getSqlMapClientTemplate().queryForObject(
                "findWeightUnitByName", name);
    }

    public List<WeightUnit> findAllWeightUnits() {
        return (List<WeightUnit>) this.getSqlMapClientTemplate().queryForList("findAllWeightUnits");
    }

    public List<WeightUnit> findAllWeightUnits(int offset, int limit) {
        return (List<WeightUnit>) this.getSqlMapClientTemplate().queryForList(
                "findAllWeightUnits", offset, limit);
    }

    public int findWeightUnitCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findWeightUnitCount");
    }
    /* END WEIGHT */

    /* VOLUME */
    public List<VolumeUnit> findAllVolumeUnits() {
        return (List<VolumeUnit>) this.getSqlMapClientTemplate().queryForList("findAllVolumeUnits");
    }
    /* END VOLUME */

    /* RECIPE */
    public int createRecipe(Recipe r) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertRecipe", r);
        return id.intValue();
    }

    public void updateRecipe(Recipe r) {
        this.getSqlMapClientTemplate().update("updateRecipe", r);
    }

    public Recipe findRecipeById(int id) {
        Recipe r = (Recipe) this.getSqlMapClientTemplate().queryForObject("findRecipeById", id);
        if (r == null) { throw new ObjectNotFoundException("Recipe ID: " + id); }
        return r;
    }

    public List<Recipe> findRecipesByUser(int id) {
        return (List<Recipe>) this.getSqlMapClientTemplate().queryForList("findRecipesByUser", id);
    }

    public int createRecipeGrain(int recipeId, GrainInstance g) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert(
                "insertRecipeGrain", this.createParams("recipeId", recipeId, "instance", g));
        return id.intValue();
    }

    public int deleteRecipeGrainsByRecipe(int id) {
        return this.getSqlMapClientTemplate().delete("deleteRecipeGrainsByRecipe", id);
    }
    /* END RECIPE */

    /* HOP ADDITION TYPE */
    public int createHopsAdditionType(HopsAdditionType hat) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertHopsAdditionType", hat);
        return id.intValue();
    }

    public void updateHopsAdditionType(HopsAdditionType hat) {
        this.getSqlMapClientTemplate().update("updateHopsAdditionType", hat);
    }

    public HopsAdditionType findHopsAdditionTypeById(int id) {
        HopsAdditionType hat = (HopsAdditionType) this.getSqlMapClientTemplate().queryForObject(
                "findHopsAdditionTypeById", id);
        if (hat == null) { throw new ObjectNotFoundException("Hop addition type ID: " + id); }
        return hat;
    }

    public HopsAdditionType findHopsAdditionTypeByName(String name) {
        return (HopsAdditionType) this.getSqlMapClientTemplate().queryForObject(
                "findHopsAdditionTypeByName", name);
    }

    public List<HopsAdditionType> findAllHopsAdditionTypes() {
        return (List<HopsAdditionType>) this.getSqlMapClientTemplate().queryForList(
                "findAllHopsAdditionTypes");
    }

    public List<HopsAdditionType> findAllHopsAdditionTypes(int offset, int limit) {
        return (List<HopsAdditionType>) this.getSqlMapClientTemplate().queryForList(
                "findAllHopsAdditionTypes", offset, limit);
    }

    public int findHopsAdditionTypeCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findHopsAdditionTypeCount");
    }
    /* END HOP ADDITION TYPE */
}
