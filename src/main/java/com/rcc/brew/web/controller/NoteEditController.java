package com.rcc.brew.web.controller;

import com.rcc.brew.model.Model;
import com.rcc.brew.bean.Note;

import com.rcc.beans.Identifiable;
import com.rcc.web.FlashUtils;
import com.rcc.web.HistoryUtils;
import com.rcc.web.controller.AbstractEditController;
import com.rcc.web.controller.ControllerUtils;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

public class NoteEditController extends AbstractEditController {
    private static final Log log = LogFactory.getLog(NoteEditController.class);

    private Model model;
    private String objectType;

    public void setModel(Model model) { this.model = model; }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    protected Identifiable formNewBackingObject() throws Exception {
        Note note = new Note();
        note.setObjectType(this.objectType);
        return note;
    }

    protected Identifiable formExistingBackingObject(int id) throws Exception {
        return this.model.findNoteById(id);
    }

    protected void internalReferenceData(Map map, HttpServletRequest request, Object command,
            Errors errors)
        throws Exception
    {
        int h = ControllerUtils.getIntParam(request, "d", 0);
        String cancelPath = HistoryUtils.redirectPath(request, h);
        map.put("cancelPath", cancelPath);
    }

    protected ModelAndView processCreateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Note note = (Note) command;

        int id = this.model.createNote(note);

        FlashUtils.messageCode("note.create.success", request);

        int h = ControllerUtils.getIntParam(request, "d", 0);
        return new ModelAndView("redirect:" + HistoryUtils.redirectPath(request, h));
    }

    protected ModelAndView processUpdateFormSubmission(
            HttpServletRequest request, HttpServletResponse response,
            Identifiable command, BindException errors)
        throws Exception
    {
        Note note = (Note) command;

        this.model.updateNote(note);

        FlashUtils.messageCode("note.update.success", request);

        int h = ControllerUtils.getIntParam(request, "d", 0);
        return new ModelAndView("redirect:" + HistoryUtils.redirectPath(request, h));
    }
}
