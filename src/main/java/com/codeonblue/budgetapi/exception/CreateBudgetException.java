package com.codeonblue.budgetapi.exception;

public class CreateBudgetException extends RuntimeException {
    public CreateBudgetException(String message, Throwable cause) {
        super(message, cause);
    }
}
