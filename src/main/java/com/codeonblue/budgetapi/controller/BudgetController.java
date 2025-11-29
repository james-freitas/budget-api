package com.codeonblue.budgetapi.controller;

import com.codeonblue.budgetapi.dto.BudgetRequestDto;
import com.codeonblue.budgetapi.dto.BudgetResponseDto;
import com.codeonblue.budgetapi.service.BudgetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/budgets")
public class BudgetController {

    private final BudgetServiceImpl budgetServiceImpl;

    public BudgetController(BudgetServiceImpl budgetServiceImpl) {
        this.budgetServiceImpl = budgetServiceImpl;
    }

    @PostMapping
    public ResponseEntity<BudgetResponseDto> createBudget(@RequestBody BudgetRequestDto budgetRequestDto) {
        var response = budgetServiceImpl.createBudget(budgetRequestDto.toModel()).toResponse();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
