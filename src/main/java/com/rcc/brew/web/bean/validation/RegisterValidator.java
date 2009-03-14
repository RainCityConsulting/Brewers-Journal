package com.rcc.brew.web.bean.validation;

import com.rcc.brew.bean.User;
import com.rcc.brew.web.bean.Register;
import com.rcc.brew.model.Model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterValidator implements Validator {
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public boolean supports(Class clazz) {
        return Register.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        Register r = (Register) obj;

        if (r.hasMail()) {
            User user = this.model.findUserByMail(r.getMail());
            if (user != null) {
                errors.rejectValue("mail", "validation.duplicate");
            }
        }

        if (r.hasName()) {
            User user = this.model.findUserByName(r.getName());
            if (user != null) {
                errors.rejectValue("name", "validation.duplicate");
            }
        }

        if (r.hasPassword() && r.hasPasswordCheck()) {
            if (!r.getPassword().equals(r.getPasswordCheck())) {
                errors.rejectValue("passwordCheck", "register.password.check.fail");
            }
        }
    }
}
