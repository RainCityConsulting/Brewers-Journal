package com.rcc.brew.web.bean.validation;

import com.rcc.brew.bean.User;
import com.rcc.brew.web.bean.Login;
import com.rcc.brew.model.Model;
import com.rcc.brew.util.DigestUtils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator, InitializingBean {
    private Model model;

    public void afterPropertiesSet() throws Exception {
        if (this.model == null) {
            throw new IllegalStateException("model must be set");
        }
    }

    public void setModel(Model model) { this.model = model; }

    public boolean supports(Class clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        Login login = (Login) obj;

        if (login.hasMail()) {
            User user = this.model.findUserByMail(login.getMail());
            if (user == null) {
                errors.reject("login.fail");
                return;
            }

            if (login.hasPassword()) {
                String encPassword = DigestUtils.clearPasswordDigest(
                        login.getPassword(), user.getSalt());
                if (!user.getEncryptedPassword().equals(encPassword)) {
                    errors.reject("login.fail");
                    return;
                }
            }
        }
    }
}
