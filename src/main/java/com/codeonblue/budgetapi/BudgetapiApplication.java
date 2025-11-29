package com.codeonblue.budgetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BudgetapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetapiApplication.class, args);
	}

}
