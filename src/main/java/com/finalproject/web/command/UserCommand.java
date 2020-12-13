package com.finalproject.web.command;

import com.finalproject.dao.EntityDao;
import com.finalproject.entity.User;
import com.finalproject.enums.DaoType;
import com.finalproject.factory.DaoFactory;
import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.finalproject.constants.PageUrlConstants.USER_PAGE;

public class UserCommand implements Command {

    private static final String COUNT_ATTRIBUTE = "count";
    private EntityDao<User> userDao;

    public UserCommand() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }

    @Override
    public Page perform(HttpServletRequest request) {
        long userCount = userDao.getAll().size();
        request.setAttribute(COUNT_ATTRIBUTE, userCount);
        return new Page(USER_PAGE);
    }

    public void setUserDao(EntityDao userDao) {
        this.userDao = userDao;
    }
}

