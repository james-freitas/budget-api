package com.codeonblue.budgetapi.dto;

import com.codeonblue.budgetapi.model.Budget;

public record BudgetRequestDto(
        String month,
        Integer year
) {
    public Budget toModel() {
        return new Budget(
                "",
                this.month,
                this.year
        );
    }
}
