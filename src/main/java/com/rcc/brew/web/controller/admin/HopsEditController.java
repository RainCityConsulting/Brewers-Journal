package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.Hops;
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

public class HopsEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(HopsEditController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected Identifiable formNewBackingObject() throws Exception {
        Hops hops = new Hops();
        return hops;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findHopsById(id);
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
        Hops hops = (Hops) command;

        int id = this.model.createHops(hops);

        FlashUtils.messageCode("hops.create.success", request, hops.getName());

        return new ModelAndView("redirect:/admin/hops.s?id=" + id);
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Hops hops = (Hops) command;

        this.model.updateHops(hops);

        FlashUtils.messageCode("hops.update.success", request, hops.getName());

        return new ModelAndView("redirect:/admin/hops.s?id=" + hops.getId());
    }
}
