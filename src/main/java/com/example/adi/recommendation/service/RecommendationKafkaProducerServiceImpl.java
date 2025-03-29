package com.example.adi.recommendation.service;

import com.example.adi.recommendation.config.ConstantsConfig;
import com.example.adi.recommendation.model.BidRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RecommendationKafkaProducerServiceImpl implements RecommendationKafkaProducerService{
    @Autowired
    private KafkaTemplate<String, BidRecommendation> kafkaTemplate;

    @Override
    public void publish(BidRecommendation bidRecommendation) {
        this.kafkaTemplate.send(ConstantsConfig.BIDDING_TOPIC, bidRecommendation);
    }
}
