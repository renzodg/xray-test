package com.viking.poc;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@XRayEnabled
public class BudgetService {

  @Autowired
  private BudgetRepository budgetRepository;

  public Double getBudget () {
    return budgetRepository.getBudgetAmount();
  }

}
