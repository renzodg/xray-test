/* Copyright 2023 eLocal*/
package com.viking.poc;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.plugins.ECSPlugin;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {"com.viking"})
@ConfigurationPropertiesScan
public class BudgetApplication {
  public static void main(String[] args) {
    SpringApplication.run(BudgetApplication.class, args);
    configureAWSXrayRecorder();
  }

  private static void configureAWSXrayRecorder() {
    AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard()
            .withSegmentListener(new CustomSLF4JSegmentListener(""))
//            .withSamplingStrategy(new LocalizedSamplingStrategy(BudgetApplication.class.getResource("/sampling-rules.json"), true))
            .withPlugin(new ECSPlugin())
            .withFastIdGenerator()
            .withForcedTraceIdGeneration();

    AWSXRay.setGlobalRecorder(builder.build());
  }
}
