package com.viking.poc;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

@Repository
@XRayEnabled
public class UserRepository {

  @SneakyThrows
  public String getFullName(String id) {
    Thread.sleep(800L);
    return "John Smith";
  }

  @SneakyThrows
  public void createUser() {
    Thread.sleep(800L);
  }
}
