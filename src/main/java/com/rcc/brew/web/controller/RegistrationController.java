package com.rcc.brew.web.controller;

import com.rcc.brew.bean.Audit;
import com.rcc.brew.bean.User;
import com.rcc.brew.web.bean.Register;
import com.rcc.brew.model.Model;
import com.rcc.brew.util.DigestUtils;

import com.rcc.web.FlashUtils;
import com.rcc.web.controller.AbstractFormController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

public class RegistrationController extends AbstractFormController {
    private static final Log log = LogFactory.getLog(RegistrationController.class);

    private Model model;

    public void setModel(Model model) { this.model = model; }

    protected void referenceData(Map map) throws Exception {
        map.put("content", "Register");
    }

    protected ModelAndView internalProcessFormSubmission(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
        throws Exception
    {
        Register r = (Register) command;

        String salt = DigestUtils.createSalt();

        User user = new User();
        user.setName(r.getName());
        user.setMail(r.getMail());
        user.setEncryptedPassword(DigestUtils.clearPasswordDigest(r.getPassword(), salt));
        user.setSalt(salt);
        user.setAuthToken(salt.substring(0, 4));
        user.setAuthenticated(false);
        user.setAudit(new Audit());
        user.getAudit().setCreationUserId(1);
        user.getAudit().setLastUpdatedUserId(1);

        int id = this.model.createUser(user);

        user = this.model.findUserById(id);

        FlashUtils.messageCode("register.success", request, user.getName(), user.getMail());

        request.getSession().setAttribute("nonAuthUser", user);

        return new ModelAndView("redirect:/user/auth/mail.s");
    }
}
