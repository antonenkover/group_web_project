package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Page perform(HttpServletRequest request);
}
