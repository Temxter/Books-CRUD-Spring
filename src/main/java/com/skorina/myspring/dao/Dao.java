package com.skorina.myspring.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();
    T get(int id);
    void create(T item);
    void update(T item);
    void delete(int id);
}
