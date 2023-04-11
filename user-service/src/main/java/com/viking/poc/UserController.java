package com.viking.poc;

import io.opentelemetry.api.trace.Span;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User getUser(@PathVariable String id, @RequestParam boolean filter) {
    log.info("UserController.getUser");
    return userService.getUserData(id);
  }

  @PostMapping
  public void createUser(@RequestBody User user) {
    log.info("UserController.createUser");
    Span.current().setAttribute("payload", user.toString());
    userService.createUser(user);
  }
}
