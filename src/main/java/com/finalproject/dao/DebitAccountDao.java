package com.finalproject.dao;

import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import org.apache.log4j.Logger;

import java.util.List;

public class DebitAccountDao extends AbstractDao<DebitAccount> {
    public static final String COLUMN_BALANCE = "balance";
    public static final String COLUMN_DEBIT_RATE = "debit_rate";
    public static final String COLUMN_DEPOSITED_SUM = "deposited_sum";
    public static final String COLUMN_DEPOSIT_START = "deposit_start";
    public static final String COLUMN_DEPOSIT_END = "deposit_end";
    public static final String COLUMN_DEPOSIT_DURATION = "deposit_duration";
    public static final String COLUMN_ACCOUNT_ID = "account_id";
    public static final String INSERT_INTO_DEBIT_ACCOUNT = "INSERT INTO `debit_account` ("
            + COLUMN_BALANCE + ", "
            + COLUMN_DEBIT_RATE + ", "
            + COLUMN_DEPOSITED_SUM + ", "
            + COLUMN_DEPOSIT_START + ", "
            + COLUMN_DEPOSIT_END + ", "
            + COLUMN_DEPOSIT_DURATION + ", "
            + COLUMN_ACCOUNT_ID + ") VALUE (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DEBIT_ACCOUNT = "UPDATE `debit_account` SET "
            + COLUMN_BALANCE + " = ?, " + COLUMN_DEBIT_RATE + " = ?, " + COLUMN_DEPOSITED_SUM
            + " = ?, " + COLUMN_DEPOSIT_START + " = ?, " + COLUMN_DEPOSIT_END + " = ?, " + COLUMN_DEPOSIT_DURATION
            + " = ?, " + COLUMN_ACCOUNT_ID + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_DEBIT_ACCOUNT = "DELETE FROM `debit_account` " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(CreditAccountDao.class);
    private static final String SELECT_FROM_DEBIT_ACCOUNT = "SELECT * FROM `debit_account`";

    @Override
    public List<DebitAccount> getAll() {
        return getAll(SELECT_FROM_DEBIT_ACCOUNT, getMapper());
    }

    public EntityMapper<DebitAccount> getMapper() {
        return resultSet -> new DebitAccount(
                resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_BALANCE),
                resultSet.getInt(COLUMN_DEBIT_RATE),
                resultSet.getInt(COLUMN_DEPOSITED_SUM),
                resultSet.getString(COLUMN_DEPOSIT_START),
                resultSet.getString(COLUMN_DEPOSIT_END),
                resultSet.getInt(COLUMN_DEPOSIT_DURATION),
                resultSet.getInt(COLUMN_ACCOUNT_ID));
    }

    @Override
    public boolean create(DebitAccount entity) {
        LOG.debug("Create debit account " + entity);
        return createUpdate(INSERT_INTO_DEBIT_ACCOUNT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getBalance());
            preparedStatement.setInt(2, entity.getDebitRate());
            preparedStatement.setInt(3, entity.getDepositedSum());
            preparedStatement.setString(4, entity.getDepositStart());
            preparedStatement.setString(5, entity.getDepositEnd());
            preparedStatement.setInt(6, entity.getDepositDuration());
            preparedStatement.setInt(7, entity.getAccountId());
        });
    }

    @Override
    public boolean update(DebitAccount entity) {
        LOG.debug("Update debit account " + entity);
        return createUpdate(UPDATE_DEBIT_ACCOUNT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getBalance());
            preparedStatement.setInt(2, entity.getDebitRate());
            preparedStatement.setInt(3, entity.getDepositedSum());
            preparedStatement.setString(4, entity.getDepositStart());
            preparedStatement.setString(5, entity.getDepositEnd());
            preparedStatement.setInt(6, entity.getDepositDuration());
            preparedStatement.setInt(7, entity.getAccountId());
            preparedStatement.setInt(8, entity.getId());
        });
    }

    @Override
    public boolean remove(DebitAccount entity) {
        LOG.debug("Delete debit account " + entity);
        return createUpdate(DELETE_DEBIT_ACCOUNT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getId());
        });
    }

    public DebitAccount getById(int id, boolean full) {
        return getById("SELECT * FROM `debit_account` WHERE account_id = ?",
                preparedStatement -> preparedStatement.setInt(1, id),
                getMapper());
    }
}
