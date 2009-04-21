package com.rcc.brew.util;

import com.rcc.brew.model.Model;

import org.springframework.context.ApplicationContext;

public class DomainUtils {
    public static int RECIPE_OBJECT_TYPE_ID;

    public static void init(ApplicationContext ctx) {
        Model model = (Model) ctx.getBean("model");

        RECIPE_OBJECT_TYPE_ID = model.findObjectTypeIdByName("recipe");
    }
}
