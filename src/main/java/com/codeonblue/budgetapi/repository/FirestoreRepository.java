package com.codeonblue.budgetapi.repository;

public interface FirestoreRepository<T> {
    T save(String id, T entity) throws Exception;
}
