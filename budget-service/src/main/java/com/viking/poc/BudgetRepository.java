package com.viking.poc;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetRepository {

  @SneakyThrows
  @WithSpan
  public Double getBudgetAmount() {
    Thread.sleep(300L);
    return 253.40;
  }

}
