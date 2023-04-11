package com.viking.poc;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

  @Autowired
  private BudgetRepository budgetRepository;

  @WithSpan
  public Double getBudget () {
    return budgetRepository.getBudgetAmount();
  }

}
