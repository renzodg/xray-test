package com.viking.poc;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.entities.Segment;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@XRayEnabled
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User getUser(@PathVariable String id, @RequestParam boolean filter) {
    log.info("testing-log");
    return userService.getUserData(id);
  }

  @PostMapping
  public void createUser(@RequestBody User user) {
    Segment currentSegment = AWSXRay.getCurrentSegment();
    currentSegment.putMetadata("payload", user);
    userService.createUser(user);
  }
}
