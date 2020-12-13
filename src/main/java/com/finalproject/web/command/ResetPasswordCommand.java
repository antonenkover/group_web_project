package com.finalproject.web.command;

import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.finalproject.constants.PageUrlConstants.HOME_PAGE;
import static com.finalproject.constants.PageUrlConstants.RESET_PASSWORD;

public class ResetPasswordCommand extends MultiCommand {

    public ResetPasswordCommand() {

    }


    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(RESET_PASSWORD);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        return new Page(HOME_PAGE);
    }
}
