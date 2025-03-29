package com.example.adi.recommendation.service;

import com.example.adi.recommendation.config.ConstantsConfig;
import com.example.adi.recommendation.model.BidRecommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecommendationKafkaProducerServiceImpl implements RecommendationKafkaProducerService{
    @Autowired
    private KafkaTemplate<String, BidRecommendation> kafkaTemplate;
    @Autowired
    private ConstantsConfig constantsConfig;

    @Override
    public void publish(BidRecommendation bidRecommendation) {
        log.info("Produced: {}", bidRecommendation);
        this.kafkaTemplate.send(constantsConfig.getBiddingTopic(), bidRecommendation);
    }
}
