package com.finalproject.dao;

import com.finalproject.entity.OperationsType;
import org.apache.log4j.Logger;

import java.util.List;

public class OperationsTypeDao extends AbstractDao<OperationsType> {

    public static final String COLUMN_OPERATION_TYPE = "operation_type";
    public static final String INSERT_INTO_OPERATIONS_TYPE = "INSERT INTO operations_type (" + COLUMN_OPERATION_TYPE + ") VALUE (?)";
    public static final String UPDATE_OPERATIONS_TYPE = "UPDATE operations_type "
            + COLUMN_OPERATION_TYPE + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_OPERATIONS_TYPE = "DELETE FROM operations_type " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(ServicesDao.class);
    private static final String SELECT_FROM_OPERATIONS_TYPE = "SELECT * FROM operations_type";

    @Override
    public List<OperationsType> getAll() {
        return getAll(SELECT_FROM_OPERATIONS_TYPE, getMapper());
    }

    private EntityMapper<OperationsType> getMapper() {
        return resultSet -> new OperationsType(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_OPERATION_TYPE));
    }

    @Override
    public boolean create(OperationsType entity) {
        LOG.debug("Create operation type: + " + entity);
        return createUpdate(INSERT_INTO_OPERATIONS_TYPE, preparedStatement -> {
            preparedStatement.setString(1, entity.getOperationType());
        });
    }

    @Override
    public boolean update(OperationsType entity) {
        LOG.debug("Update operation type: + " + entity);
        return createUpdate(UPDATE_OPERATIONS_TYPE, preparedStatement -> {
            preparedStatement.setString(1, entity.getOperationType());
        });
    }

    @Override
    public boolean remove(OperationsType entity) {
        LOG.debug("Delete operation type: + " + entity);
        return createUpdate(DELETE_OPERATIONS_TYPE, preparedStatement -> {
            preparedStatement.setInt(1, entity.getId());
        });
    }
}
