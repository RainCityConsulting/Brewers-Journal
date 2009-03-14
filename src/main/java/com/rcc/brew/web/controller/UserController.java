package com.rcc.brew.web.controller;

import com.rcc.brew.bean.User;
import com.rcc.brew.model.Model;

import com.rcc.mail.VelocityMailer;
import com.rcc.web.FlashUtils;
import com.rcc.web.controller.ControllerUtils;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController extends MultiActionController {
    private Model model;
    private VelocityMailer mailer;

    public void setModel(Model model) { this.model = model; }
    public void setVelocityMailer(VelocityMailer mailer) { this.mailer = mailer; }

    public ModelAndView sendAuthMail(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        User user = (User) request.getSession().getAttribute("nonAuthUser");

        if (user == null) {
            FlashUtils.errorCode("bad.request", request);
            return new ModelAndView("redirect:/index.s");
        }

        List to = new ArrayList<String>();
        to.add(user.getMail());

        List bcc = new ArrayList<String>();
        bcc.add("ian@raincityconsulting.com");

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("user", user);

        this.mailer.send("accounts@raincityconsulting.com", to, null, bcc,
                "AuthEmailSubject.txt", null, "AuthEmailText.txt", context);

        FlashUtils.messageCode("register.instructions", request, user.getMail());

        return new ModelAndView("redirect:/index.s");
    }

    public ModelAndView auth(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        int id = ControllerUtils.getIntParam(request, "id", 0);

        if (id == 0) {
            FlashUtils.errorCode("bad.request", request);
            return new ModelAndView("redirect:/index.s");
        }

        String token = request.getParameter("token");
        if (token == null) {
            FlashUtils.errorCode("bad.request", request);
            return new ModelAndView("redirect:/index.s");
        }

        User user = this.model.findUserById(id);

        if (user.isAuthenticated()) {
            FlashUtils.messageCode("user.already.auth", request, user.getMail());
            return new ModelAndView("redirect:/index.s");
        }

        if (token.equals(user.getAuthToken())) {
            user.setAuthenticated(true);
            this.model.updateUser(user);
            request.getSession().setAttribute("user", this.model.findUserById(id));
            FlashUtils.messageCode("user.auth.success", request, user.getName());
            FlashUtils.messageCode("login.success", request, user.getName());
        } else {
            FlashUtils.errorCode("user.auth.fail", request, user.getName());
        }

        return new ModelAndView("redirect:/index.s");
    }

    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();

        FlashUtils.messageCode("logout.success", request);

        return new ModelAndView("redirect:/index.s");
    }
}
