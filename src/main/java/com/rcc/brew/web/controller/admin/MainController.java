package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.Adjunct;
import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.HopsAdditionType;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.bean.Yeast;
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

    public ModelAndView adjunct(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);
        if (id == 0) {
            List<Adjunct> adjuncts = this.model.findAllAdjuncts();
            mav.addObject("content", "admin/AdjunctList");
            mav.addObject("adjuncts", adjuncts);
        } else {
            Adjunct adjunct = this.model.findAdjunctById(id);
            mav.addObject("content", "admin/Adjunct");
            mav.addObject("adjunct", adjunct);
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

    public ModelAndView yeast(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);
        if (id == 0) {
            List<Yeast> yeast = this.model.findAllYeast();
            mav.addObject("content", "admin/YeastList");
            mav.addObject("yeast", yeast);
        } else {
            Yeast yeast = this.model.findYeastById(id);
            mav.addObject("content", "admin/Yeast");
            mav.addObject("yeast", yeast);
        }

        return mav;
    }

    public ModelAndView hopsAdditionType(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        List<HopsAdditionType> hats = this.model.findAllHopsAdditionTypes();
        mav.addObject("content", "admin/HopsAdditionTypeList");
        mav.addObject("hats", hats);

        return mav;
    }

    public ModelAndView hops(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        int id = com.rcc.web.controller.ControllerUtils.getIntParam(request, "id", 0);
        if (id == 0) {
            List<Hops> hops = this.model.findAllHops();
            mav.addObject("content", "admin/HopsList");
            mav.addObject("hops", hops);
        } else {
            Hops hops = this.model.findHopsById(id);
            mav.addObject("content", "admin/Hops");
            mav.addObject("hops", hops);
        }

        return mav;
    }

    public ModelAndView color(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("content", "admin/Color");
        return mav;
    }
}
