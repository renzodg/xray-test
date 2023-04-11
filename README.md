# AWS X-Ray Proof of Concept

## Run application with Java Agent
* Download the [latest version of AWS OpenTelemetry Java Agent](https://github.com/aws-observability/aws-otel-java-instrumentation/releases/latest/download/aws-opentelemetry-agent.jar)
- Run the application using the agent, i.e. `-javaagent:{path-to-jar}`

## Environment variables
* OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:5555
* OTEL_METRICS_EXPORTER=none
* OTEL_TRACES_EXPORTER=logging
* OTEL_RESOURCE_ATTRIBUTES=service.name=user-service,service.namespace=viking,aws.log.group.names=/ecs/viking-dev-type-ahead