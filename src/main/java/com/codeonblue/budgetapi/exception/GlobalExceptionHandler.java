package com.codeonblue.budgetapi.exception;

import com.codeonblue.budgetapi.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @ExceptionHandler(CreateBudgetException.class)
    public ResponseEntity<ErrorResponseDto> handleCreateBudgetException(CreateBudgetException ex, HttpServletRequest request) {
        var timestamp = OffsetDateTime.now().format(FORMATTER);
        var status = HttpStatus.BAD_REQUEST;
        var body = new ErrorResponseDto(
                timestamp,
                status.getReasonPhrase(),
                ex.getClass().getName(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex, HttpServletRequest request) {
        var errorId = UUID.randomUUID().toString();

        var timestamp = OffsetDateTime.now().format(FORMATTER);
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var body = new ErrorResponseDto(
                timestamp,
                status.getReasonPhrase(),
                ex.getClass().getName(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(body);
    }
}

