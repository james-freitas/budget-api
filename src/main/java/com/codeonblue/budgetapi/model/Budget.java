package com.codeonblue.budgetapi.model;

import com.codeonblue.budgetapi.dto.BudgetResponseDto;
import de.huxhorn.sulky.ulid.ULID;

public class Budget {

    private String id;
    private String month;
    private Integer year;

    public Budget() {}

    public Budget(String id, String month, Integer year) {
        this.id = new ULID().nextULID();
        this.month = month;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public BudgetResponseDto toResponse() {
        return new BudgetResponseDto(
                this.id,
                this.month,
                this.year
        );
    }
}
