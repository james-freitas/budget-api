package com.codeonblue.budgetapi.dto;

public record BudgetResponseDto(
        String id,
        String month,
        Integer year
) {}
