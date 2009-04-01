package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.model.Model;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

public class MainController extends MultiActionController {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public ModelAndView view(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        mav.addObject("content", "admin/Index");

        return mav;
    }

    public ModelAndView mfg(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);
        if (id == 0) {
            List<Mfg> mfgs = this.model.findAllMfgs();
            mav.addObject("content", "admin/MfgList");
            mav.addObject("mfgs", mfgs);
        } else {
            Mfg mfg = this.model.findMfgById(id);
            mav.addObject("content", "admin/Mfg");
            mav.addObject("mfg", mfg);
        }

        return mav;
    }

    public ModelAndView grain(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);
        if (id == 0) {
            List<Grain> grains = this.model.findAllGrains();
            mav.addObject("content", "admin/GrainList");
            mav.addObject("grains", grains);
        } else {
            Grain grain = this.model.findGrainById(id);
            mav.addObject("content", "admin/Grain");
            mav.addObject("grain", grain);
        }

        return mav;
    }
}