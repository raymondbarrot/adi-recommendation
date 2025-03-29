package com.example.adi.recommendation.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ConstantsConfig {
    @Value("${kafka.topic.recommendation}")
    private String recommendationTopic;

    @Value("${kafka.topic.bidding}")
    private String biddingTopic;

    @Value("${kafka.bootstrap.server}")
    private String kafkaServer;
}
