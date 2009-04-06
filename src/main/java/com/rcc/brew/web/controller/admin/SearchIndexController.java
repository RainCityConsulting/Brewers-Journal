package com.rcc.brew.web.controller.admin;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.Mfg;
import com.rcc.brew.model.Model;

import com.rcc.search.IndexWriter;
import com.rcc.web.FlashUtils;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

public class SearchIndexController extends MultiActionController {
    private IndexWriter<Grain> grainIndexWriter;
    private IndexWriter<Hops> hopsIndexWriter;
    private Model model;

    public void setGrainIndexWriter(IndexWriter<Grain> grainIndexWriter) {
        this.grainIndexWriter = grainIndexWriter;
    }

    public void setHopsIndexWriter(IndexWriter<Hops> hopsIndexWriter) {
        this.hopsIndexWriter = hopsIndexWriter;
    }

    public void setModel(Model model) { this.model = model; }

    public ModelAndView view(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView();

        mav.addObject("content", "admin/SearchIndex");

        return mav;
    }

    public ModelAndView rebuildGrainIndex(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        List<Grain> grains = this.model.findAllGrains();
        boolean overwrite = true;
        for (Grain g : grains) {
            this.grainIndexWriter.add(g, overwrite);
            overwrite = false;
        }

        FlashUtils.messageCode("index.rebuild.success", request, "Grain");

        return new ModelAndView("redirect:/admin/search.s");
    }

    public ModelAndView rebuildHopsIndex(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        List<Hops> hops = this.model.findAllHops();
        boolean overwrite = true;
        for (Hops h : hops) {
            this.hopsIndexWriter.add(h, overwrite);
            overwrite = false;
        }

        FlashUtils.messageCode("index.rebuild.success", request, "Hops");

        return new ModelAndView("redirect:/admin/search.s");
    }
}
