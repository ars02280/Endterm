package com.example.end.repository;

import java.util.List;

public interface CrudRepository<T, ID> {
    T create(T entity);
    T getById(ID id);
    List<T> getAll();
    void update(T entity);
    void delete(ID id);
    T getByName(String name);
}