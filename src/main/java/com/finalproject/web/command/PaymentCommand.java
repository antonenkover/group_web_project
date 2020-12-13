package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class PaymentCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page("services", true);
    }
}
