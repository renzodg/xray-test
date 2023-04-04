/* Copyright 2023 eLocal*/
package com.viking.poc;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.plugins.ECSPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {"com.viking"})
@ConfigurationPropertiesScan
public class UserApplication {
  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
    configureAWSXrayRecorder();
  }

  private static void configureAWSXrayRecorder() {
    AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard()
            .withSegmentListener(new CustomSLF4JSegmentListener(""))
//            .withSamplingStrategy(new LocalizedSamplingStrategy(UserApplication.class.getResource("/sampling-rules.json")))
            .withPlugin(new ECSPlugin())
            .withFastIdGenerator()
            .withForcedTraceIdGeneration();

    AWSXRay.setGlobalRecorder(builder.build());
  }
}
