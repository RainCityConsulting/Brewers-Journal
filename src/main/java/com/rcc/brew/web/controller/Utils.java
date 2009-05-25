package com.rcc.brew.web.controller;

import com.rcc.web.HistoryUtils;
import com.rcc.web.controller.ControllerUtils;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static ModelAndView redirect(HttpServletRequest request, String fallback) {
        int h = ControllerUtils.getIntParam(request, "d", -1);
        if (h >= 0) {
            return new ModelAndView("redirect:" + HistoryUtils.redirectPath(request, h));
        }
        return new ModelAndView("redirect:" + fallback);
    }
}
