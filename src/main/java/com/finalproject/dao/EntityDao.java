package com.finalproject.dao;

import java.util.List;

public interface EntityDao<T> {

    T getByLogin(String login, boolean full);

    T getById(int id, boolean full);

    List<T> getAll();

    boolean create(T entity);

    boolean update(T entity);

    boolean remove(T entity);

}
