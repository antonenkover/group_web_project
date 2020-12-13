package com.finalproject.dao;

import com.finalproject.entity.MoneyTransfer;
import org.apache.log4j.Logger;

import java.util.List;

public class MoneyTransferDao extends AbstractDao<MoneyTransfer> {
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_TRANSFERRED_SUM = "transferred_sum";
    public static final String COLUMN_OPERATION_TIME = "operation_time";
    public static final String COLUMN_OPERATION_TYPE_ID = "operation_type_id";
    public static final String SELECT_FROM_MONEY_TRANSFER = "SELECT * FROM money_transfer";
    public static final String INSERT_INTO_MONEY_TRANSFER = "INSERT INTO money_transfer ("
            + COLUMN_USER_ID + COLUMN_TRANSFERRED_SUM + COLUMN_OPERATION_TIME + COLUMN_OPERATION_TYPE_ID + ") VALUE (?, ?, ?, ?, ?)";
    public static final String UPDATE_MONEY_TRANSFER = "UPDATE money_transfer "
            + COLUMN_USER_ID + " = ?, " + COLUMN_TRANSFERRED_SUM + " = ?, " + COLUMN_OPERATION_TIME + " = ?, " + COLUMN_OPERATION_TYPE_ID
            + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_USER = "DELETE FROM money_transfer " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(UserDao.class);

    @Override
    public List<MoneyTransfer> getAll() {
        return getAll(SELECT_FROM_MONEY_TRANSFER, getMapper());
    }

    private EntityMapper<MoneyTransfer> getMapper() {
        return resultSet -> new MoneyTransfer(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_USER_ID),
                resultSet.getInt(COLUMN_TRANSFERRED_SUM),
                resultSet.getString(COLUMN_OPERATION_TIME),
                resultSet.getInt(COLUMN_OPERATION_TYPE_ID));
    }

    @Override
    public boolean create(MoneyTransfer entity) {
        LOG.debug("Create money transfer: + " + entity);
        return createUpdate(INSERT_INTO_MONEY_TRANSFER, preparedStatement -> {
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getTransferredSum());
            preparedStatement.setString(3, entity.getOperationTime());
            preparedStatement.setInt(4, entity.getOperationTypeId());
        });
    }

    @Override
    public boolean update(MoneyTransfer entity) {
        LOG.debug("Create money transfer: + " + entity);
        return createUpdate(UPDATE_MONEY_TRANSFER, preparedStatement -> {
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getTransferredSum());
            preparedStatement.setString(3, entity.getOperationTime());
            preparedStatement.setInt(4, entity.getOperationTypeId());
            preparedStatement.setInt(5, entity.getId());
        });
    }

    @Override
    public boolean remove(MoneyTransfer entity) {
        LOG.debug("Create money transfer: + " + entity);
        return createUpdate(DELETE_USER, preparedStatement -> {
            preparedStatement.setInt(1, entity.getId());
        });
    }
}
