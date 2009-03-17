package com.rcc.brew.web.controller;

import com.rcc.brew.bean.User;
import com.rcc.brew.web.bean.Login;
import com.rcc.brew.model.Model;

import com.rcc.web.FlashUtils;
import com.rcc.web.controller.AbstractFormController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

public class LoginController extends AbstractFormController {
    private static final Log log = LogFactory.getLog(LoginController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected void referenceData(Map map) throws Exception {
        map.put("content", "Login");
    }

    protected ModelAndView internalProcessFormSubmission(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
        throws Exception
    {
        Login login = (Login) command;

        User user = this.model.findUserByMail(login.getName());
        if (user == null) {
            user = this.model.findUserByName(login.getName());
        }

        FlashUtils.messageCode("login.success", request, user.getName());

        request.getSession().setAttribute("user", user);

        return new ModelAndView("redirect:/index.s");
    }
}
