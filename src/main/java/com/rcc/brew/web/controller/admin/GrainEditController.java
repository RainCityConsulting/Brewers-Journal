package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.User;
import com.rcc.brew.model.Model;
import com.rcc.brew.web.bean.propertyeditor.MfgIdPropertyEditor;

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

public class GrainEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(GrainEditController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected Identifiable formNewBackingObject() throws Exception {
        Grain grain = new Grain();
        return grain;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findGrainById(id);
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
        throws Exception
    {
        MfgIdPropertyEditor ed = new MfgIdPropertyEditor();
        ed.setModel(this.model);
        binder.registerCustomEditor(Mfg.class, ed);
    }

    protected void referenceData(Map map) {
        map.put("mfgs", this.model.findAllMfgs());
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Grain grain = (Grain) command;

        int id = this.model.createGrain(grain);

        FlashUtils.messageCode("grain.create.success", request, grain.getName());

        return new ModelAndView("redirect:/admin/grain.s?id=" + id);
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Grain grain = (Grain) command;

        this.model.updateGrain(grain);

        FlashUtils.messageCode("grain.update.success", request, grain.getName());

        return new ModelAndView("redirect:/admin/grain.s?id=" + grain.getId());
    }
}
