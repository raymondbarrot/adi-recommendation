package com.example.adi.recommendation.service;

import com.example.adi.recommendation.model.BidRecommendation;
public interface RecommendationKafkaProducerService {
    void publish(BidRecommendation bidRecommendation);

}
