package com.finalproject.dao;

import com.finalproject.entity.User;
import com.finalproject.entity.UserCreditAccountData;
import com.finalproject.enums.SecurityAccess;

import java.util.List;

public class UserCreditAccountDataDao extends AbstractDao<UserCreditAccountData>{
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_BALANCE = "balance";
    public static final String COLUMN_CREDIT_LIMIT = "credit_limit";
    public static final String COLUMN_STATUS = "credit_status";
    public static final String COLUMN_DEBT = "dept";
    public static final String COLUMN_PERCENTAGE = "percentage";
    public static final String COLUMN_CREDIT_RATE = "credit_rate";
    public static final String COLUMN_DEPOSIT_START = "deposit_start";
    public static final String COLUMN_DEPOSIT_END = "deposit_end";
    public static final String COLUMN_DEPOSIT_DURATION = "deposit_duration";
    public static final String COLUMN_ACCOUNT_ID = "account_id";
    private static final String GET_ALL_USER_ACCOUNT_DATA = "SELECT system_user.name, system_user.surname, credit_account.credit_status, credit_account.balance, credit_account.credit_limit, credit_account.dept, credit_account.percentage, credit_account.credit_rate, credit_account.deposit_start, credit_account.deposit_end, credit_account.deposit_duration, credit_account.account_id FROM system_user JOIN credit_account on system_user.account_id = credit_account.account_id";
    @Override
    public List<UserCreditAccountData> getAll() {
        return getAll(GET_ALL_USER_ACCOUNT_DATA, getMapper());
    }

    private EntityMapper<UserCreditAccountData> getMapper() {
        return resultSet -> new UserCreditAccountData(
                resultSet.getString(COLUMN_NAME),
                resultSet.getString(COLUMN_SURNAME),
                resultSet.getString(COLUMN_STATUS),
                resultSet.getInt(COLUMN_BALANCE),
                resultSet.getInt(COLUMN_CREDIT_LIMIT),
                resultSet.getInt(COLUMN_DEBT),
                resultSet.getInt(COLUMN_PERCENTAGE),
                resultSet.getInt(COLUMN_CREDIT_RATE),
                resultSet.getString(COLUMN_DEPOSIT_START),
                resultSet.getString(COLUMN_DEPOSIT_END),
                resultSet.getInt(COLUMN_DEPOSIT_DURATION),
                resultSet.getInt(COLUMN_ACCOUNT_ID));
    }

    @Override
    public boolean create(UserCreditAccountData entity) {
        return false;
    }

    @Override
    public boolean update(UserCreditAccountData entity) {
        return false;
    }

    @Override
    public boolean remove(UserCreditAccountData entity) {
        return false;
    }
}
