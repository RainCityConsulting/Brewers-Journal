package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.User;
import com.rcc.brew.model.Model;

import com.rcc.beans.Identifiable;
import com.rcc.web.FlashUtils;
import com.rcc.web.controller.AbstractEditController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MfgEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(MfgEditController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected Identifiable formNewBackingObject() throws Exception {
        Mfg mfg = new Mfg();
        return mfg;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findMfgById(id);
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Mfg mfg = (Mfg) command;

        int id = this.model.createMfg(mfg);

        FlashUtils.messageCode("mfg.create.success", request, mfg.getName());

        return new ModelAndView("redirect:/admin/mfg.s?id=" + id);
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Mfg mfg = (Mfg) command;

        this.model.updateMfg(mfg);

        FlashUtils.messageCode("mfg.update.success", request, mfg.getName());

        return new ModelAndView("redirect:/admin/mfg.s?id=" + mfg.getId());
    }
}
