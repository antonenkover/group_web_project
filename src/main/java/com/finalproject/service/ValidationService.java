package com.finalproject.service;

import com.finalproject.dao.EntityDao;
import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import com.finalproject.enums.DaoType;
import com.finalproject.enums.SecurityAccess;
import com.finalproject.factory.DaoFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ValidationService {
    private static final Logger LOG = Logger.getLogger(ValidationService.class);
    private EntityDao<User> userDao;

    public ValidationService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }

    public Optional<User> validateUser(String login, String password) {
        List<User> all = userDao.getAll();

        return all.stream()
                .filter(u -> u.getLogin().equals(login)
                        && u.getPassword().equals(password))
                .findFirst();
    }

    public boolean validateLogin(String login) {
        List<User> users = userDao.getAll();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                LOG.debug("Login not validated: " + user.getLogin());
                return false;
            }
        }
        return true;
    }


    public boolean isExist(String login) {
        List<User> all = userDao.getAll();
        return all.stream()
                .anyMatch(u -> u.getLogin().equals(login));
    }

    public User registrationUser(String login, String password, String name, String surname) {
        Random random = new Random();
        int accountId = random.nextInt(900) + 1000;
        User newUser = new User(login, password, name, surname, accountId, SecurityAccess.USER);
        userDao.create(newUser);
        return newUser;
    }

}
