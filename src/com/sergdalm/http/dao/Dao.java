package com.sergdalm.http.dao;

import java.util.List;
import java.util.Optional;

/***
 *
 * @param <K> is  id
 * @param <T> is entity
 */
public interface Dao<K, T> {

    List<T> findAll();

    Optional<T> findId(K id);

    boolean delete(K id);

    void update(T entity);

    T save(T entity);
}
