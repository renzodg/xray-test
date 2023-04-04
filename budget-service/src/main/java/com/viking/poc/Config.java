package com.viking.poc;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class Config {

  @Bean
  public Filter TracingFilter() {
    return new AWSXRayServletFilter("budget-service");
  }

}
