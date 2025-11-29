package com.codeonblue.budgetapi.service;

import com.codeonblue.budgetapi.exception.CreateBudgetException;
import com.codeonblue.budgetapi.model.Budget;
import com.google.cloud.firestore.Firestore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final Firestore firestore;
    private static final String COLLECTION_NAME = "budget";
    private static final Logger log = LoggerFactory.getLogger(BudgetServiceImpl.class);

    public BudgetServiceImpl(Firestore firestore) {
        this.firestore = firestore;
    }

    @Override
    public Budget createBudget(Budget budget) {
        log.info("Creating budget: {}", budget);
        try {
            firestore.collection(COLLECTION_NAME).document().set(budget);
            return budget;
        } catch (Exception e) {
            log.error("Error creating budget: {}", e.getMessage());
            throw new CreateBudgetException("Failed to create budget", e);
        }
    }
}
