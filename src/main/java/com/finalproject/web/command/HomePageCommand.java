package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.finalproject.constants.PageUrlConstants.HOME_PAGE;

public class HomePageCommand implements Command {

//    private static final String USERNAME = "username";

    public HomePageCommand() {
    }

    @Override
    public Page perform(HttpServletRequest request) {
//        HttpSession session = request.getSession();
        return new Page(HOME_PAGE);
    }
}
