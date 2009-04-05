package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.HopsAdditionType;
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

public class HopsAdditionTypeEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(HopsAdditionTypeEditController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected Identifiable formNewBackingObject() throws Exception {
        HopsAdditionType hat = new HopsAdditionType();
        return hat;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findHopsAdditionTypeById(id);
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        HopsAdditionType hat = (HopsAdditionType) command;

        int id = this.model.createHopsAdditionType(hat);

        FlashUtils.messageCode("hat.create.success", request, hat.getName());

        return new ModelAndView("redirect:/admin/hat.s?id=" + id);
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        HopsAdditionType hat = (HopsAdditionType) command;

        this.model.updateHopsAdditionType(hat);

        FlashUtils.messageCode("hat.update.success", request, hat.getName());

        return new ModelAndView("redirect:/admin/hat.s?id=" + hat.getId());
    }
}
