package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class LanguageCommand implements Command {

    private static final String LOCALE = "locale";

    @Override
    public Page perform(HttpServletRequest request) {
        String locale = request.getParameter(LOCALE);

        if (locale != null) {
            request.getSession().setAttribute(LOCALE, locale);
        }

        return new Page("/", true);
    }
}
