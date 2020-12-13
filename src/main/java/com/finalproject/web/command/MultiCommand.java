package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public abstract class MultiCommand implements Command {

    @Override
    public Page perform(HttpServletRequest request) {
        String type = request.getMethod();

        return "GET".equals(type)
                ? performGet(request)
                : performPost(request);
    }

    protected abstract Page performGet(HttpServletRequest request);

    protected abstract Page performPost(HttpServletRequest request);
}
