package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.finalproject.constants.PageUrlConstants.ACCOUNT_PAGE;


public class AccountCommand implements Command {

    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(ACCOUNT_PAGE, true);
    }

}
