package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Batch;
import com.rcc.brew.bean.Gravity;
import com.rcc.brew.bean.GravityReading;
import com.rcc.brew.bean.GravityUnit;
import com.rcc.brew.model.Model;

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

import java.util.Map;

public class GravityReadingEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(GravityReadingEditController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected Identifiable formNewBackingObject() throws Exception {
        GravityReading reading = new GravityReading();
        reading.setGravity(new Gravity());
        return reading;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findGravityReadingById(id);
    }

    protected void referenceData(Map map) {
        map.put("gravityUnits", this.model.findAllGravityUnits());
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        GravityReading reading = (GravityReading) command;

        int id = this.model.createGravityReading(reading);

        Batch batch = this.model.findBatchById(reading.getBatchId());

        FlashUtils.messageCode("gravity.reading.create.success", request, batch.getName());

        return new ModelAndView("redirect:/batch.s?id=" + batch.getId());
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        GravityReading reading = (GravityReading) command;

        this.model.updateGravityReading(reading);

        Batch batch = this.model.findBatchById(reading.getBatchId());

        FlashUtils.messageCode("gravity.reading.update.success", request, batch.getName());

        return new ModelAndView("redirect:/batch.s?id=" + batch.getId());
    }
}
