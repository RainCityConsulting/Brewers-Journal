package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Batch;
import com.rcc.brew.bean.GravityReading;
import com.rcc.brew.bean.User;
import com.rcc.brew.model.Model;
import com.rcc.brew.util.ContextUtils;

import com.rcc.web.FlashUtils;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

public class BatchController extends MultiActionController {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public ModelAndView view(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        User user = ContextUtils.getRequestContext(false).getUser();

        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);

        if (id == 0) {
            List<Batch> batches = this.model.findBatchesByUser(user.getId());
            mav.addObject("content", "BatchList");
            mav.addObject("batches", batches);
        } else {
            Batch batch = this.model.findBatchById(id);

            mav.addObject("content", "Batch");
            mav.addObject("batch", batch);
        }

        return mav;
    }

    public ModelAndView deleteGravityReading(
            HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        User user = ContextUtils.getRequestContext(false).getUser();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);

        GravityReading reading = this.model.findGravityReadingById(id);
        Batch batch = this.model.findBatchById(reading.getBatchId());

        if (batch.getAudit().getCreationUserId() != user.getId()) {
            FlashUtils.warningCode("user.abuse", request);
            return new ModelAndView("redirect:/index.s");
        }

        this.model.deleteGravityReadingById(id);

        FlashUtils.messageCode("gravity.reading.delete.success", request);

        return new ModelAndView("redirect:/batch.s?id=" + batch.getId());
    }
}
