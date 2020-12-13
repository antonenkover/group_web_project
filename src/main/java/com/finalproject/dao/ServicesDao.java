package com.finalproject.dao;

import com.finalproject.entity.Services;
import org.apache.log4j.Logger;

import java.util.List;

public class ServicesDao extends AbstractDao<Services> {

    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ACCOUNT_ID = "account_id";
    public static final String INSERT_INTO_SERVICES = "INSERT INTO services (" + COLUMN_TITLE + COLUMN_ACCOUNT_ID + ") VALUE (?)";
    public static final String UPDATE_SERVICES = "UPDATE services " + COLUMN_TITLE + " = ?, " + COLUMN_ACCOUNT_ID + "= ? WHERE " + COLUMN_ID + " = ? )";
    public static final String DELETE_SERVICES = "DELETE FROM services " + "WHERE " + COLUMN_ID + " = ?";
    private static final Logger LOG = Logger.getLogger(ServicesDao.class);
    private static final String SELECT_FROM_SERVICES = "SELECT * FROM services";

    @Override
    public List<Services> getAll() {
        return getAll(SELECT_FROM_SERVICES, getMapper());
    }

    private EntityMapper<Services> getMapper() {
        return resultSet -> new Services(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_TITLE),
                resultSet.getInt(COLUMN_ACCOUNT_ID));
    }

    @Override
    public boolean create(Services entity) {
        LOG.debug("Create service: + " + entity);
        return createUpdate(INSERT_INTO_SERVICES, preparedStatement -> {
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setInt(2, entity.getAccountId());
        });
    }

    @Override
    public boolean update(Services entity) {
        LOG.debug("Update service: " + entity);
        return createUpdate(UPDATE_SERVICES, preparedStatement -> {
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setInt(2, entity.getAccountId());
            preparedStatement.setInt(3, entity.getId());
        });
    }

    @Override
    public boolean remove(Services entity) {
        LOG.debug("Delete service: " + entity);
        return createUpdate(DELETE_SERVICES, preparedStatement -> preparedStatement
                .setInt(1, entity.getId()));
    }
}
