package com.finalproject.web.command;

import com.finalproject.dao.UserDao;
import com.finalproject.entity.User;
import com.finalproject.factory.ServiceFactory;
import com.finalproject.service.ValidationService;
import com.finalproject.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.finalproject.constants.PageUrlConstants.REGISTRATION_PAGE;

public class RegistrationCommand extends MultiCommand {
    private static final Logger LOG = Logger.getLogger(RegistrationCommand.class);
    UserDao userDao;
    private ValidationService vs;

    public RegistrationCommand() {
        this.vs = ServiceFactory.getValidationService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(REGISTRATION_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        LOG.info("Registration name: " + name + ", surname: " + surname + ", login: " + login + ", password: " + password);

        HttpSession session = request.getSession(true);

        boolean exist = vs.isExist(login);

        if (exist) {
            String locale = (String) session.getAttribute("locale");
            if (locale.equals("en"))
                session.setAttribute("error_login_exists", "Login is already taken.");
            else {
                session.setAttribute("error_login_exists", "Этот логин уже занят.");
            }
            return new Page(REGISTRATION_PAGE, true);
        }

        User newUser = vs.registrationUser(login, password, name, surname);
        LOG.debug("Registration of a  user: + " + newUser);
        session.setAttribute("user", newUser);

        return new Page("/", true);
    }
}
