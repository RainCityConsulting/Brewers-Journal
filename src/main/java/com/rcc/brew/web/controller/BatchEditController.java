package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Adjunct;
import com.rcc.brew.bean.AdjunctInstance;
import com.rcc.brew.bean.Batch;
import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.GrainInstance;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.HopsInstance;
import com.rcc.brew.bean.MashStep;
import com.rcc.brew.bean.MashStepType;
import com.rcc.brew.bean.Temp;
import com.rcc.brew.bean.TempUnit;
import com.rcc.brew.bean.Time;
import com.rcc.brew.bean.TimeUnit;
import com.rcc.brew.bean.User;
import com.rcc.brew.bean.Volume;
import com.rcc.brew.bean.VolumeUnit;
import com.rcc.brew.bean.Weight;
import com.rcc.brew.bean.WeightUnit;
import com.rcc.brew.bean.YeastInstance;
import com.rcc.brew.model.Model;
import com.rcc.brew.service.Service;

import com.rcc.beans.Identifiable;
import com.rcc.web.FlashUtils;
import com.rcc.web.controller.AbstractEditController;

import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BatchEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(BatchEditController.class);

    private Model model;
    private Service service;

    public void setModel(Model model) { this.model = model; }
    public void setService(Service service) { this.service = service; }

    protected Identifiable formNewBackingObject() throws Exception {
        Batch batch = new Batch();

        batch.setVolume(new Volume(new VolumeUnit()));
        batch.setBoilTime(new Time(new TimeUnit()));

        List<AdjunctInstance> adjuncts = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            AdjunctInstance ai = new AdjunctInstance();
                            ai.setWeight(new Weight(new WeightUnit()));
                            ai.setVolume(new Volume(new VolumeUnit()));
                            return ai;
                        }
        });
        for (int i = 0; i < 4; i++) { adjuncts.get(i); }
        batch.setAdjuncts(adjuncts);

        List<GrainInstance> grains = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            GrainInstance gi = new GrainInstance();
                            gi.setWeight(new Weight(new WeightUnit()));
                            return gi;
                        }
        });
        for (int i = 0; i < 4; i++) { grains.get(i); }
        batch.setGrains(grains);

        List<HopsInstance> hops = new AutoPopulatingList(new AutoPopulatingList.ElementFactory() {
                public Object createElement(int index) {
                    HopsInstance hi = new HopsInstance();
                    hi.setWeight(new Weight(new WeightUnit()));
                    hi.setTime(new Time(new TimeUnit()));
                    hi.setAdditionType(new HopsAdditionType());
                    return hi;
                }
        });
        for (int i = 0; i < 6; i++) { hops.get(i); }
        batch.setHops(hops);

        List<YeastInstance> yeast = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            YeastInstance yi = new YeastInstance();
                            return yi;
                        }
        });
        for (int i = 0; i < 1; i++) { yeast.get(i); }
        batch.setYeast(yeast);

        List<MashStep> mash = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            MashStep ms = new MashStep();
                            ms.setType(new MashStepType());
                            ms.setTime(new Time(new TimeUnit()));
                            ms.setStartTemp(new Temp(new TempUnit()));
                            ms.setEndTemp(new Temp(new TempUnit()));
                            return ms;
                        }
        });
        for (int i = 0; i < 3; i++) { mash.get(i); }
        batch.setMash(mash);

        return batch;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        Batch batch = this.model.findBatchById(id);

        List<AdjunctInstance> adjuncts = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            AdjunctInstance ai = new AdjunctInstance();
                            ai.setWeight(new Weight(new WeightUnit()));
                            ai.setVolume(new Volume(new VolumeUnit()));
                            return ai;
                        }
        });
        adjuncts.addAll(batch.getAdjuncts());
        for (AdjunctInstance a : adjuncts) {
            if (!a.hasWeight()) {
                a.setWeight(new Weight(new WeightUnit()));
            }
            if (!a.hasVolume()) {
                a.setVolume(new Volume(new VolumeUnit()));
            }
        }
        batch.setAdjuncts(adjuncts);

        List<GrainInstance> grains = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            GrainInstance gi = new GrainInstance();
                            gi.setWeight(new Weight(new WeightUnit()));
                            return gi;
                        }
        });
        grains.addAll(batch.getGrains());
        batch.setGrains(grains);

        List<HopsInstance> hops = new AutoPopulatingList(new AutoPopulatingList.ElementFactory() {
                public Object createElement(int index) {
                    HopsInstance hi = new HopsInstance();
                    hi.setWeight(new Weight(new WeightUnit()));
                    hi.setTime(new Time(new TimeUnit()));
                    hi.setAdditionType(new HopsAdditionType());
                    return hi;
                }
        });
        hops.addAll(batch.getHops());
        batch.setHops(hops);

        for (HopsInstance hi : batch.getHops()) {
            if (!hi.hasTime()) {
                hi.setTime(new Time(new TimeUnit()));
            }
        }

        List<YeastInstance> yeast = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            YeastInstance y = new YeastInstance();
                            return y;
                        }
        });
        yeast.addAll(batch.getYeast());
        batch.setYeast(yeast);

        List<MashStep> mash = new AutoPopulatingList(
                new AutoPopulatingList.ElementFactory() {
                        public Object createElement(int index) {
                            MashStep ms = new MashStep();
                            ms.setType(new MashStepType());
                            ms.setTime(new Time(new TimeUnit()));
                            ms.setStartTemp(new Temp(new TempUnit()));
                            ms.setEndTemp(new Temp(new TempUnit()));
                            return ms;
                        }
        });
        mash.addAll(batch.getMash());
        for (MashStep m : mash) {
            if (!m.hasTime()) {
                m.setTime(new Time(new TimeUnit()));
            }
        }
        batch.setMash(mash);

        return batch;
    }

    protected void referenceData(Map map) {
        map.put("weightUnits", this.model.findAllWeightUnits());
        map.put("volumeUnits", this.model.findAllVolumeUnits());
        map.put("timeUnits", this.model.findAllTimeUnits());
        map.put("tempUnits", this.model.findAllTempUnits());
        map.put("hats", this.model.findAllHopsAdditionTypes());
        map.put("msts", this.model.findAllMashStepTypes());
    }

    protected void onBind(HttpServletRequest request, Object command) throws Exception {
        Batch batch = (Batch) command;

        for (Iterator<MashStep> i = batch.getMash().iterator(); i.hasNext();) {
            MashStep m = i.next();
            if (!m.hasType()) { i.remove(); }
        }

        for (Iterator<AdjunctInstance> i = batch.getAdjuncts().iterator(); i.hasNext();) {
            AdjunctInstance a = i.next();
            if (!a.hasAdjunct()) { i.remove(); }
        }

        for (Iterator<GrainInstance> i = batch.getGrains().iterator(); i.hasNext();) {
            GrainInstance g = i.next();
            if (!g.hasGrain()) { i.remove(); }
        }

        for (Iterator<HopsInstance> i = batch.getHops().iterator(); i.hasNext();) {
            HopsInstance h = i.next();
            if (!h.hasHops()) { i.remove(); }
        }

        for (Iterator<YeastInstance> i = batch.getYeast().iterator(); i.hasNext();) {
            YeastInstance y = i.next();
            if (!y.hasYeast()) { i.remove(); }
        }
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Batch batch = (Batch) command;
        int id = this.service.createBatch(batch);
        FlashUtils.messageCode("batch.create.success", request, batch.getName());
        return new ModelAndView("redirect:/batch.s?id=" + id);
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Batch batch = (Batch) command;
        this.service.updateBatch(batch);
        FlashUtils.messageCode("batch.update.success", request, batch.getName());
        return new ModelAndView("redirect:/batch.s?id=" + batch.getId());
    }
}
