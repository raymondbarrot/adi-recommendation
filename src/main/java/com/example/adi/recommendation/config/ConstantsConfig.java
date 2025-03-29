package com.example.adi.recommendation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConstantsConfig {
    @Value("${kafka.topic.recommendation}")
    public static String RECOMMENDATION_TOPIC;

    @Value("${kafka.topic.bidding}")
    public static String BIDDING_TOPIC;

    @Value("${kafka.bootstrap.server}")
    public static String KAFKA_SERVER;

}
