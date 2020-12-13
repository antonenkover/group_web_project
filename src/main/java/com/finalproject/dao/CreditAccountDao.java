package com.finalproject.dao;

import com.finalproject.entity.CreditAccount;
import org.apache.log4j.Logger;

import java.util.List;

public class CreditAccountDao extends AbstractDao<CreditAccount> {
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
    public static final String INSERT_INTO_CREDIT_ACCOUNT = "INSERT INTO `credit_account` ("
            + COLUMN_STATUS + ", "
            + COLUMN_BALANCE + ", "
            + COLUMN_CREDIT_LIMIT + ", "
            + COLUMN_DEBT + ", "
            + COLUMN_PERCENTAGE + ", "
            + COLUMN_CREDIT_RATE + ", "
            + COLUMN_DEPOSIT_START + ", "
            + COLUMN_DEPOSIT_END + ", "
            + COLUMN_DEPOSIT_DURATION + ", "
            + COLUMN_ACCOUNT_ID + ") VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_CREDIT_ACCOUNT = "UPDATE `credit_account` "
            + COLUMN_STATUS + " = ?, "
            + COLUMN_BALANCE + " = ?, "
            + COLUMN_CREDIT_LIMIT + " = ?, "
            + COLUMN_DEBT + " = ?, "
            + COLUMN_PERCENTAGE + " = ?, "
            + COLUMN_CREDIT_RATE + " = ?, "
            + COLUMN_DEPOSIT_START + " = ?, "
            + COLUMN_DEPOSIT_END + " = ?, "
            + COLUMN_DEPOSIT_DURATION + " = ?, "
            + COLUMN_ACCOUNT_ID + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_CREDIT_ACCOUNT = "DELETE FROM `credit_account` " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(CreditAccountDao.class);
    private static final String SELECT_FROM_CREDIT_ACCOUNT = "SELECT * FROM `credit_account`";

    @Override
    public List<CreditAccount> getAll() {
        return getAll(SELECT_FROM_CREDIT_ACCOUNT, getMapper());
    }

    private EntityMapper<CreditAccount> getMapper() {
        return resultSet -> new CreditAccount(resultSet.getInt(COLUMN_ID),
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
    public boolean create(CreditAccount entity) {
        LOG.debug("Create credit account: + " + entity);
        return createUpdate(INSERT_INTO_CREDIT_ACCOUNT, preparedStatement -> {
            preparedStatement.setString(1,  entity.getStatus());
            preparedStatement.setInt(2, entity.getBalance());
            preparedStatement.setInt(3, entity.getCreditLimit());
            preparedStatement.setInt(4, entity.getDebt());
            preparedStatement.setInt(5, entity.getPercentage());
            preparedStatement.setInt(6, entity.getCreditRate());
            preparedStatement.setString(7, entity.getDepositStart());
            preparedStatement.setString(8, entity.getDepositEnd());
            preparedStatement.setInt(9, entity.getDepositDuration());
            preparedStatement.setInt(10, entity.getAccountId());
        });
    }

    @Override
    public boolean update(CreditAccount entity) {
        LOG.debug("Update credit account: " + entity);
        return createUpdate(UPDATE_CREDIT_ACCOUNT, preparedStatement -> {
            preparedStatement.setString(1, entity.getStatus());
            preparedStatement.setInt(2, entity.getBalance());
            preparedStatement.setInt(3, entity.getCreditLimit());
            preparedStatement.setInt(4, entity.getDebt());
            preparedStatement.setInt(5, entity.getPercentage());
            preparedStatement.setInt(6, entity.getCreditRate());
            preparedStatement.setString(7, entity.getDepositStart());
            preparedStatement.setString(8, entity.getDepositEnd());
            preparedStatement.setInt(9, entity.getDepositDuration());
            preparedStatement.setInt(10, entity.getAccountId());
            preparedStatement.setInt(11, entity.getId());
        });
    }

    @Override
    public boolean remove(CreditAccount entity) {
        LOG.debug("Delete credit account: " + entity);
        return createUpdate(DELETE_CREDIT_ACCOUNT, preparedStatement -> preparedStatement
                .setInt(1, entity.getId()));
    }
}
