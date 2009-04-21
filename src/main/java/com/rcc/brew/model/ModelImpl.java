package com.rcc.brew.model;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.HopsInstance;
import com.rcc.brew.bean.MashStepType;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.Note;
import com.rcc.brew.bean.Recipe;
import com.rcc.brew.bean.TempUnit;
import com.rcc.brew.bean.TimeUnit;
import com.rcc.brew.bean.User;
import com.rcc.brew.bean.VolumeUnit;
import com.rcc.brew.bean.WeightUnit;
import com.rcc.brew.bean.Yeast;
import com.rcc.brew.bean.YeastInstance;

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

    /* HOPS */
    public int createHops(Hops g) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertHops", g);
        return id.intValue();
    }

    public void updateHops(Hops g) {
        this.getSqlMapClientTemplate().update("updateHops", g);
    }

    public Hops findHopsById(int id) {
        Hops g = (Hops) this.getSqlMapClientTemplate().queryForObject("findHopsById", id);
        if (g == null) { throw new ObjectNotFoundException("Hops ID: " + id); }
        return g;
    }

    public Hops findHopsByName(String name) {
        return (Hops) this.getSqlMapClientTemplate().queryForObject("findHopsByName", name);
    }

    public List<Hops> findAllHops() {
        return (List<Hops>) this.getSqlMapClientTemplate().queryForList("findAllHops");
    }

    public List<Hops> findAllHops(int offset, int limit) {
        return (List<Hops>) this.getSqlMapClientTemplate().queryForList(
                "findAllHops", offset, limit);
    }

    public int findHopsCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findHopsCount");
        
    }
    /* END HOPS */

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

    /* YEAST */
    public int createYeast(Yeast g) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertYeast", g);
        return id.intValue();
    }

    public void updateYeast(Yeast g) {
        this.getSqlMapClientTemplate().update("updateYeast", g);
    }

    public Yeast findYeastById(int id) {
        Yeast g = (Yeast) this.getSqlMapClientTemplate().queryForObject("findYeastById", id);
        if (g == null) { throw new ObjectNotFoundException("Yeast ID: " + id); }
        return g;
    }

    public Yeast findYeastByName(String name) {
        return (Yeast) this.getSqlMapClientTemplate().queryForObject("findYeastByName", name);
    }

    public List<Yeast> findAllYeast() {
        return (List<Yeast>) this.getSqlMapClientTemplate().queryForList("findAllYeast");
    }

    public List<Yeast> findAllYeast(int offset, int limit) {
        return (List<Yeast>) this.getSqlMapClientTemplate().queryForList(
                "findAllYeast", offset, limit);
    }

    public int findYeastCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findYeastCount");
        
    }
    /* END YEAST */

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
    public VolumeUnit findVolumeUnitById(int id) {
        return (VolumeUnit) this.getSqlMapClientTemplate().queryForObject("findVolumeUnitById", id);
    }

    public VolumeUnit findVolumeUnitByName(String name) {
        return (VolumeUnit) this.getSqlMapClientTemplate().queryForObject(
                "findVolumeUnitByName", name);
    }

    public List<VolumeUnit> findAllVolumeUnits() {
        return (List<VolumeUnit>) this.getSqlMapClientTemplate().queryForList("findAllVolumeUnits");
    }

    public List<VolumeUnit> findAllVolumeUnits(int offset, int limit) {
        return (List<VolumeUnit>) this.getSqlMapClientTemplate().queryForList(
                "findAllVolumeUnits", offset, limit);
    }

    public int findVolumeUnitCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findVolumeUnitCount");
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

    /* RECIPE HOPS */
    public int createRecipeHops(int recipeId, HopsInstance h) {
        if (h.hasTime()) {
            if (!h.getTime().hasValue()) {
                h.setTime(null);
            }
        }

        Integer id = (Integer) this.getSqlMapClientTemplate().insert(
                "insertRecipeHops", this.createParams("recipeId", recipeId, "instance", h));
        return id.intValue();
    }

    public int deleteRecipeHopsByRecipe(int id) {
        return this.getSqlMapClientTemplate().delete("deleteRecipeHopsByRecipe", id);
    }
    /* END RECIPE HOPS */

    /* RECIPE YEAST */
    public int createRecipeYeast(int recipeId, YeastInstance y) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert(
                "insertRecipeYeast", this.createParams("recipeId", recipeId, "instance", y));
        return id.intValue();
    }

    public int deleteRecipeYeastByRecipe(int id) {
        return this.getSqlMapClientTemplate().delete("deleteRecipeYeastByRecipe", id);
    }
    /* END RECIPE YEAST */

    /* TEMP */
    public TempUnit findTempUnitById(int id) {
        return (TempUnit) this.getSqlMapClientTemplate().queryForObject("findTempUnitById", id);
    }

    public TempUnit findTempUnitByName(String name) {
        return (TempUnit) this.getSqlMapClientTemplate().queryForObject(
                "findTempUnitByName", name);
    }

    public List<TempUnit> findAllTempUnits() {
        return (List<TempUnit>) this.getSqlMapClientTemplate().queryForList("findAllTempUnits");
    }

    public List<TempUnit> findAllTempUnits(int offset, int limit) {
        return (List<TempUnit>) this.getSqlMapClientTemplate().queryForList(
                "findAllTempUnits", offset, limit);
    }

    public int findTempUnitCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findTempUnitCount");
    }
    /* END TEMP */

    /* TIME */
    public TimeUnit findTimeUnitById(int id) {
        return (TimeUnit) this.getSqlMapClientTemplate().queryForObject("findTimeUnitById", id);
    }

    public TimeUnit findTimeUnitByName(String name) {
        return (TimeUnit) this.getSqlMapClientTemplate().queryForObject(
                "findTimeUnitByName", name);
    }

    public List<TimeUnit> findAllTimeUnits() {
        return (List<TimeUnit>) this.getSqlMapClientTemplate().queryForList("findAllTimeUnits");
    }

    public List<TimeUnit> findAllTimeUnits(int offset, int limit) {
        return (List<TimeUnit>) this.getSqlMapClientTemplate().queryForList(
                "findAllTimeUnits", offset, limit);
    }

    public int findTimeUnitCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject("findTimeUnitCount");
    }
    /* END TIME */

    /* NOTES */
    public int createNote(Note n) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert("insertNote", n);
        return id.intValue();
    }

    public void updateNote(Note n) {
        this.getSqlMapClientTemplate().update("updateNote", n);
    }

    public Note findNoteById(int id) {
        Note n = (Note) this.getSqlMapClientTemplate().queryForObject("findNoteById", id);
        if (n == null) { throw new ObjectNotFoundException("Note ID: " + id); }
        return n;
    }

    public List<Note> findNotesByObjectTypeAndObject(int objectTypeId, int objectId) {
        return (List<Note>) this.getSqlMapClientTemplate().queryForList(
                "findNotesByObjectTypeIdAndObjectId",
                this.createParams("objectTypeId", objectTypeId, "objectId", objectId));
    }

    public int deleteNoteById(int id) {
        return this.getSqlMapClientTemplate().delete("deleteNoteById", id);
    }

    public int deleteNotesByObjectTypeAndObject(int objectTypeId, int objectId) {
        return this.getSqlMapClientTemplate().delete("deleteNotesByObjectTypeAndObject",
                this.createParams("objectTypeId", objectTypeId, "objectId", objectId));
    }
    /* END NOTES */

    /* OBJECT TYPES */
    public int findObjectTypeIdByName(String name) {
        Integer id = (Integer) this.getSqlMapClientTemplate().queryForObject(
                "findObjectTypeIdByName", name);
        if (id == null) { throw new ObjectNotFoundException("Object type name: " + name); }
        return id.intValue();
    }
    /* END OBJECT TYPES */

    /* MASH STEP TYPE */
    public MashStepType findMashStepTypeById(int id) {
        MashStepType m = (MashStepType) this.getSqlMapClientTemplate().queryForObject(
                "findMashStepTypeById", id);
        if (m == null) { throw new ObjectNotFoundException("Mash step type ID: " + id); }
        return m;
    }

    public List<MashStepType> findAllMashStepTypes() {
        return (List<MashStepType>) this.getSqlMapClientTemplate().queryForList(
                "findAllMashStepTypes");
    }

    public List<MashStepType> findAllMashStepTypes(int offset, int limit) {
        return (List<MashStepType>) this.getSqlMapClientTemplate().queryForList(
                "findAllMashStepTypes", offset, limit);
    }
    /* END MASH STEP TYPE */
}
