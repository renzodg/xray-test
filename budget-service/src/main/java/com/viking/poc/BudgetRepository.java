package com.viking.poc;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

@Repository
@XRayEnabled
public class BudgetRepository {

  @SneakyThrows
  public Double getBudgetAmount() {
    Thread.sleep(300L);
    return 253.40;
  }

}
