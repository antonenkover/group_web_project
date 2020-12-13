package com.finalproject.dao;

import com.finalproject.db.DBConnectionPool;
import com.finalproject.entity.User;
import com.finalproject.enums.SecurityAccess;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDao extends AbstractDao<User> {
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_ACCOUNT_ID = "account_id";
    public static final String COLUMN_SECURITY_ACCESS = "security_access";
    public static final String INSERT_INTO_USER = "INSERT INTO `system_user` ("
            + COLUMN_LOGIN + ", "
            + COLUMN_PASSWORD + ", "
            + COLUMN_NAME + ", "
            + COLUMN_SURNAME + ", "
            + COLUMN_ACCOUNT_ID + ", "
            + COLUMN_SECURITY_ACCESS + ") VALUE (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER = "UPDATE `system_user` " + COLUMN_LOGIN + " = ?, " + COLUMN_PASSWORD + " = ?, "
            + COLUMN_NAME + " = ?, " + COLUMN_SURNAME + " = ?, " + COLUMN_ACCOUNT_ID + " = ?, " + COLUMN_SECURITY_ACCESS + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_USER = "DELETE FROM `system_user` " + "WHERE " + COLUMN_ID + " = ?";
    public static final String GET_USER_MONEY_OPERATIONS =
            "SELECT * FROM `system_user` join `money_transfer` on system_user.id = money_transfer.user_id";
    public static final String GET_USERS_ALL_ACCOUNT_INFO =
            "SELECT * FROM `system_user` join `debit_account` on system_user.account_id = debit_account.account_id " + "join `credit_account` on system_user.account_id = credit_account.account_id";
    public static final String VALIDATE_USER = "SELECT * FROM `system_user` WHERE " + COLUMN_LOGIN + "= ? AND " +
            COLUMN_PASSWORD + "= ?";
    public static final String GET_BY_EMAIL = "SELECT * FROM `system_user` WHERE " + COLUMN_LOGIN + "= ?";
    private static final Logger LOG = Logger.getLogger(UserDao.class);
    private static final String SELECT_FROM_USER = "SELECT * FROM system_user";

    @Override
    public List<User> getAll() {
        return getAll(SELECT_FROM_USER, getMapper());
    }

    private EntityMapper<User> getMapper() {
        return resultSet -> new User(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_LOGIN),
                resultSet.getString(COLUMN_PASSWORD),
                resultSet.getString(COLUMN_NAME),
                resultSet.getString(COLUMN_SURNAME),
                resultSet.getInt(COLUMN_ACCOUNT_ID),
                SecurityAccess.valueOf(resultSet.getString(COLUMN_SECURITY_ACCESS)));
    }

    @Override
    public boolean create(User entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_USER, preparedStatement -> {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setInt(5, entity.getAccountId());
            preparedStatement.setString(6, entity.getSecurityAccess().toString());
        });
    }

    @Override
    public boolean update(User entity) {
        LOG.debug("Update user: " + entity);
        return createUpdate(UPDATE_USER, preparedStatement -> {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setInt(5, entity.getAccountId());
            preparedStatement.setString(6, entity.getSecurityAccess().toString());
            preparedStatement.setInt(7, entity.getId());
        });
    }

    @Override
    public boolean remove(User entity) {
        LOG.debug("Delete user: " + entity);
        return createUpdate(DELETE_USER, preparedStatement -> preparedStatement
                .setInt(1, entity.getId()));
    }


    public boolean check(String name, String pass) {
        LOG.debug("Validate User: " + name + " " + pass);
        try {
            PreparedStatement preparedStatement = DBConnectionPool.getPreparedStatement(VALIDATE_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public User getByLogin(String login, boolean full) {
        return getByLogin("SELECT * FROM `system_user` WHERE login = ?",
                preparedStatement -> preparedStatement.setString(1, login),
                getMapper());
    }

    public User getByAccountId(int id, boolean full) {
        return getById("SELECT * FROM `system_user` WHERE account_id = ?",
                preparedStatement -> preparedStatement.setInt(1, id),
                getMapper());
    }
}
