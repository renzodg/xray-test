/* Copyright 2023 eLocal*/
package com.viking.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {"com.viking"})
@ConfigurationPropertiesScan
public class BudgetApplication {
  public static void main(String[] args) {
    SpringApplication.run(BudgetApplication.class, args);
  }
}
