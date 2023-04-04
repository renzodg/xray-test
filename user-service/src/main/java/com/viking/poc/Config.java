package com.viking.poc;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.proxies.apache.http.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;

@Configuration
public class Config {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){

    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(client);
    return restTemplateBuilder.requestFactory(() -> clientHttpRequestFactory).build();
  }

  @Bean
  public Filter TracingFilter() {
    return new AWSXRayServletFilter("user-service");
  }

}
