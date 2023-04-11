package com.viking.poc;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  @WithSpan
  public User getUserData(String id) {
    log.info("UserService.getUserData");
    String fullName = userRepository.getFullName(id);
    Double budgetAmount = restTemplate.getForObject("http://localhost:8001/budget", Double.class);

    return User.builder()
            .fullName(fullName)
            .budgetAmount(budgetAmount)
            .build();
  }

  @WithSpan
  public void createUser(User user) {
    log.info("UserService.createUser");
    userRepository.createUser();
  }
}

