package com.viking.poc;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@XRayEnabled
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  public User getUserData(String id) {
    String fullName = userRepository.getFullName(id);
    Double budgetAmount = restTemplate.getForObject("http://localhost:8001/budget", Double.class);

    return User.builder()
            .fullName(fullName)
            .budgetAmount(budgetAmount)
            .build();
  }

  public void createUser(User user) {
    userRepository.createUser();
  }
}

