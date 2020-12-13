package com.finalproject.dao;

import com.finalproject.entity.ServicesPayment;
import org.apache.log4j.Logger;

import java.util.List;

public class ServicesPaymentDao extends AbstractDao<ServicesPayment> {
    public static final String COLUMN_SERVICE_ID = "service_id";
    public static final String COLUMN_OPERATIONS_TYPE_ID = "operation_type_id";
    public static final String COLUMN_OPERATION_ID = "operation_id";
    public static final String INSERT_INTO_SERVICES_PAYMENT = "INSERT INTO services_payment (" + COLUMN_SERVICE_ID +
            COLUMN_OPERATIONS_TYPE_ID + COLUMN_OPERATION_ID + ") VALUE (?, ?, ?)";
    public static final String UPDATE_SERVICES_PAYMENT = "UPDATE services_payment " + COLUMN_SERVICE_ID + " = ?, " +
            COLUMN_OPERATIONS_TYPE_ID + " = ?, " + COLUMN_OPERATION_ID + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_SERVICES_PAYMENT = "DELETE FROM services_payment " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(ServicesPayment.class);
    private static final String SELECT_FROM_SERVICES_PAYMENT = "SELECT * FROM services_payment";

    @Override
    public List<ServicesPayment> getAll() {
        return getAll(SELECT_FROM_SERVICES_PAYMENT, getMapper());
    }

    private EntityMapper<ServicesPayment> getMapper() {
        return resultSet -> new ServicesPayment(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_SERVICE_ID),
                resultSet.getInt(COLUMN_OPERATIONS_TYPE_ID),
                resultSet.getInt(COLUMN_OPERATION_ID));
    }

    @Override
    public boolean create(ServicesPayment entity) {
        LOG.debug("Create service payment: + " + entity);
        return createUpdate(INSERT_INTO_SERVICES_PAYMENT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getServiceId());
            preparedStatement.setInt(2, entity.getOperationTypeId());
            preparedStatement.setInt(3, entity.getOperationId());
        });
    }

    @Override
    public boolean update(ServicesPayment entity) {
        LOG.debug(" Update service payment: " + entity);
        return createUpdate(UPDATE_SERVICES_PAYMENT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getServiceId());
            preparedStatement.setInt(2, entity.getOperationTypeId());
            preparedStatement.setInt(3, entity.getOperationId());
            preparedStatement.setInt(4, entity.getId());
        });
    }

    @Override
    public boolean remove(ServicesPayment entity) {
        LOG.debug("Delete service payment: " + entity);
        return createUpdate(DELETE_SERVICES_PAYMENT, preparedStatement -> preparedStatement
                .setInt(1, entity.getId()));
    }
}
