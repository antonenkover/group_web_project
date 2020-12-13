package com.finalproject.web.command;

import com.finalproject.dao.EntityDao;
import com.finalproject.dao.UserDao;
import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import com.finalproject.service.ValidationService;
import com.finalproject.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.finalproject.constants.PageUrlConstants.LOGIN_PAGE;

public class LoginCommand extends MultiCommand {

    private static final Logger LOG = Logger.getLogger(LoginCommand.class);
    private UserDao userDao = new UserDao();
    private ValidationService vs;
    private EntityDao<DebitAccount> debitAccountEntityDao;


    public LoginCommand() {
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return null;
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String log = request.getParameter("log");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession(true);

        if (userDao.check(log, pass)) {
            User user = userDao.getByLogin(log, true);
            LOG.info("Login user: " + user);
            session.setAttribute("user", user);
            return new Page("/", true);
        } else {
            String locale = (String) session.getAttribute("locale");
            if (locale.equals("en"))
                session.setAttribute("login_error", "Wrong login or password. Please try again.");
            else {
                session.setAttribute("login_error", "Неправильный логин или пароль. Попробуйте ещё раз.");
            }
            return new Page(LOGIN_PAGE, true);
        }
    }

}
