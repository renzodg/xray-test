package com.viking.poc;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepository {

  @SneakyThrows
  @WithSpan
  public String getFullName(String id) {
    log.info("UserRepository.getFullName");
    Thread.sleep(800L);
    return "John Smith";
  }

  @SneakyThrows
  @WithSpan
  public void createUser() {
    log.info("UserRepository.createUser");
    Thread.sleep(800L);
  }
}
