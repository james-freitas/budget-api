package com.codeonblue.budgetapi.dto;

public record ErrorResponseDto(
        String timestamp,
        String httpStatusError,
        String exceptionName,
        String path
) {}

