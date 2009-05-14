package com.rcc.brew.model;

import com.rcc.brew.bean.Adjunct;
import com.rcc.brew.bean.AdjunctInstance;
import com.rcc.brew.bean.Batch;
import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.GravityReading;
import com.rcc.brew.bean.GravityUnit;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.HopsInstance;
import com.rcc.brew.bean.MashStep;
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

    /* ADJUNCT */
    public int createAdjunct(Adjunct g);
    public void updateAdjunct(Adjunct g);
    public Adjunct findAdjunctById(int id);
    public Adjunct findAdjunctByName(String name);
    public List<Adjunct> findAllAdjuncts();
    public List<Adjunct> findAllAdjuncts(int offset, int limit);
    public int findAdjunctCount();
    /* END ADJUNCT */

    /* YEAST */
    public int createYeast(Yeast y);
    public void updateYeast(Yeast y);
    public Yeast findYeastById(int id);
    public Yeast findYeastByName(String name);
    public List<Yeast> findAllYeast();
    public List<Yeast> findAllYeast(int offset, int limit);
    public int findYeastCount();
    /* END YEAST */

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
    public VolumeUnit findVolumeUnitById(int id);
    public VolumeUnit findVolumeUnitByName(String name);
    public List<VolumeUnit> findAllVolumeUnits();
    public List<VolumeUnit> findAllVolumeUnits(int offset, int limit);
    public int findVolumeUnitCount();
    /* END VOLUME */

    /* BATCH */
    public int createBatch(Batch b);
    public void updateBatch(Batch b);
    public Batch findBatchById(int id);
    public List<Batch> findBatchesByUser(int id);
    /* END BATCH */

    /* RECIPE */
    public int createRecipe(Recipe r);
    public void updateRecipe(Recipe r);
    public Recipe findRecipeById(int id);
    public List<Recipe> findRecipesByUser(int id);
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

    /* RECIPE MASH STEPS */
    public int createRecipeMashStep(int recipeId, MashStep m);
    public int deleteRecipeMashStepsByRecipe(int id);
    /* END RECIPE MASH STEPS */

    /* RECIPE ADJUNCTS */
    public int createRecipeAdjunct(int recipeId, AdjunctInstance a);
    public int deleteRecipeAdjunctsByRecipe(int id);
    /* END RECIPE ADJUNCTS */

    /* RECIPE GRAIN */
    public int createRecipeGrain(int recipeId, GrainInstance g);
    public int deleteRecipeGrainsByRecipe(int id);
    /* END RECIPE GRAIN */

    /* RECIPE HOPS */
    public int createRecipeHops(int recipeId, HopsInstance h);
    public int deleteRecipeHopsByRecipe(int id);
    /* END RECIPE HOPS */

    /* RECIPE YEAST */
    public int createRecipeYeast(int recipeId, YeastInstance y);
    public int deleteRecipeYeastByRecipe(int id);
    /* END RECIPE YEAST */

    /* TEMP */
    public TempUnit findTempUnitById(int id);
    public TempUnit findTempUnitByName(String name);
    public List<TempUnit> findAllTempUnits();
    public List<TempUnit> findAllTempUnits(int offset, int limit);
    public int findTempUnitCount();
    /* END TEMP */

    /* GRAVITY */
    public GravityUnit findGravityUnitById(int id);
    public GravityUnit findGravityUnitByName(String name);
    public List<GravityUnit> findAllGravityUnits();
    public List<GravityUnit> findAllGravityUnits(int offset, int limit);
    public int findGravityUnitCount();
    /* END GRAVITY */

    /* GRAVITY READING */
    public GravityReading findGravityReadingById(int id);
    public int createGravityReading(GravityReading g);
    public void updateGravityReading(GravityReading g);
    /* END GRAVITY READING */

    /* TIME */
    public TimeUnit findTimeUnitById(int id);
    public TimeUnit findTimeUnitByName(String name);
    public List<TimeUnit> findAllTimeUnits();
    public List<TimeUnit> findAllTimeUnits(int offset, int limit);
    public int findTimeUnitCount();
    /* END TIME */

    /* NOTES */
    public int createNote(Note n);
    public void updateNote(Note n);
    public Note findNoteById(int id);
    public List<Note> findNotesByObjectTypeAndObject(int objectTypeId, int objectId);
    public int deleteNoteById(int id);
    public int deleteNotesByObjectTypeAndObject(int objectTypeId, int objectId);
    /* END NOTES */

    /* OBJECT TYPES */
    public int findObjectTypeIdByName(String name);
    /* END OBJECT TYPES */

    /* MASH STEP TYPE */
    public MashStepType findMashStepTypeById(int id);
    public List<MashStepType> findAllMashStepTypes();
    public List<MashStepType> findAllMashStepTypes(int offset, int limit);
    /* END MASH STEP TYPE */

    /* BATCH MASH STEPS */
    public int createBatchMashStep(int batchId, MashStep m);
    public int deleteBatchMashStepsByBatch(int id);
    /* END BATCH MASH STEPS */

    /* BATCH ADJUNCTS */
    public int createBatchAdjunct(int batchId, AdjunctInstance a);
    public int deleteBatchAdjunctsByBatch(int id);
    /* END BATCH ADJUNCTS */

    /* BATCH GRAIN */
    public int createBatchGrain(int batchId, GrainInstance g);
    public int deleteBatchGrainsByBatch(int id);
    /* END BATCH GRAIN */

    /* BATCH HOPS */
    public int createBatchHops(int batchId, HopsInstance h);
    public int deleteBatchHopsByBatch(int id);
    /* END BATCH HOPS */

    /* BATCH YEAST */
    public int createBatchYeast(int batchId, YeastInstance y);
    public int deleteBatchYeastByBatch(int id);
    /* END BATCH YEAST */
}
