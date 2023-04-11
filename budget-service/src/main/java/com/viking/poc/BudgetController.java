package com.viking.poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/budget")
@Slf4j
public class BudgetController {

  @Autowired
  private BudgetService budgetService;

  @GetMapping
  public Double getBudgetAmount(@RequestHeader Map<String, String> headers) {
    headers.forEach((key, value) -> log.info("Budget Header '{}' = {}", key, value));
    return budgetService.getBudget();
  }
}
