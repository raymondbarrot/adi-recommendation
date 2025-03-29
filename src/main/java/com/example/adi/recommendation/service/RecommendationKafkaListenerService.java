package com.example.adi.recommendation.service;

import com.example.adi.recommendation.model.InventoryRequest;

public interface RecommendationKafkaListenerService {
    public void consumeMessage(InventoryRequest inventoryRequest);
}
