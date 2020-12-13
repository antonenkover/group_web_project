package com.finalproject.dao;

import com.finalproject.entity.UserPayment;
import org.apache.log4j.Logger;

import java.util.List;

public class UserPaymentDao extends AbstractDao<UserPayment> {

    public static final String COLUMN_RECEIVER_ID = "receiver_id";
    public static final String COLUMN_OPERATIONS_TYPE_ID = "operation_type_id";
    public static final String COLUMN_OPERATION_ID = "operation_id";
    public static final String INSERT_INTO_USER_PAYMENT = "INSERT INTO user_payment (" + COLUMN_RECEIVER_ID
            + COLUMN_OPERATIONS_TYPE_ID + COLUMN_OPERATION_ID + ") VALUE (?, ?, ?)";
    public static final String UPDATE_USER_PAYMENT = "UPDATE user_payment " + COLUMN_RECEIVER_ID + " = ?, "
            + COLUMN_OPERATIONS_TYPE_ID + "= ?, "
            + COLUMN_OPERATION_ID + "= ?WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_USER_PAYMENT = "DELETE FROM user_payment " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(UserPaymentDao.class);
    private static final String SELECT_FROM_USER_PAYMENT = "SELECT * FROM user_payment";

    @Override
    public List<UserPayment> getAll() {
        return getAll(SELECT_FROM_USER_PAYMENT, getMapper());
    }

    private EntityMapper<UserPayment> getMapper() {
        return resultSet -> new UserPayment(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_RECEIVER_ID),
                resultSet.getInt(COLUMN_OPERATIONS_TYPE_ID),
                resultSet.getInt(COLUMN_OPERATION_ID));
    }

    @Override
    public boolean create(UserPayment entity) {
        LOG.debug("Create user payment: + " + entity);
        return createUpdate(INSERT_INTO_USER_PAYMENT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getReceiverId());
            preparedStatement.setInt(2, entity.getOperationTypeId());
            preparedStatement.setInt(3, entity.getOperationId());
        });
    }

    @Override
    public boolean update(UserPayment entity) {
        LOG.debug(" Update user payment: " + entity);
        return createUpdate(UPDATE_USER_PAYMENT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getReceiverId());
            preparedStatement.setInt(2, entity.getOperationTypeId());
            preparedStatement.setInt(3, entity.getOperationId());
            preparedStatement.setInt(4, entity.getId());
        });
    }

    @Override
    public boolean remove(UserPayment entity) {
        LOG.debug("Delete user payment: " + entity);
        return createUpdate(DELETE_USER_PAYMENT, preparedStatement -> preparedStatement
                .setInt(1, entity.getId()));
    }
}
