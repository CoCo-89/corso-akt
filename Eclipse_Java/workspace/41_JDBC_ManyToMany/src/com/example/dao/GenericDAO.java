package com.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
	
    Optional<T> getById(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean create(T entity) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(int id) throws SQLException;
}



