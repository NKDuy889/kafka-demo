package com.example.kafkademo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "properties.kafka")
public class KafkaParamProperties {

    private String topic = "goat";

    private Integer partition = 1;

    private Short replicationFactor = 1;

    private Integer deliveryTimeout = 5000;

    private Integer requestTimeout = 4000;

    private Integer retries = 3;
}
