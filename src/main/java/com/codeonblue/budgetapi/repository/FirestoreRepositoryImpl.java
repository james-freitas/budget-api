package com.codeonblue.budgetapi.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class FirestoreRepositoryImpl<T> implements FirestoreRepository<T> {

    private final String collectionName;

    public FirestoreRepositoryImpl(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public T save(String id, T entity) throws ExecutionException, InterruptedException {
        Firestore firestoreDb = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = firestoreDb.collection(collectionName).document(id).set(entity);
        return entity;
    }
}
