package com.example.adi.recommendation.service;

import com.example.adi.recommendation.model.AggregateBidOfferDTO;
import com.example.adi.recommendation.model.BidRecommendation;
import com.example.adi.recommendation.model.InventoryRequest;
import com.example.adi.recommendation.repository.BidOfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Slf4j
@Service
public class RecommendationKafkaListenerServiceImpl implements RecommendationKafkaListenerService{
    private final BidOfferRepository repository;
    private final RecommendationKafkaProducerService producerService;

    public RecommendationKafkaListenerServiceImpl(BidOfferRepository repository, RecommendationKafkaProducerService producerService) {
        this.repository = repository;
        this.producerService = producerService;
    }

    @Override
    @KafkaListener(topics = "${kafka.topic.recommendation}", groupId = "recommendation-group")
    public void consumeMessage(InventoryRequest inventoryRequest) {
        log.info("Consumed: {}", inventoryRequest);
        AggregateBidOfferDTO aggregateBidOfferDTO =
                repository.findAggregateBidOfferDTOItemCode(inventoryRequest.getCode());
        BidRecommendation bidRecommendation = createBidRecommendation(inventoryRequest, aggregateBidOfferDTO);
        producerService.publish(bidRecommendation);
    }

    private BidRecommendation createBidRecommendation(InventoryRequest inventoryRequest,
                                                      AggregateBidOfferDTO aggregateBidOfferDTO){
        return BidRecommendation.builder()
                .name(inventoryRequest.getName())
                .code(inventoryRequest.getCode())
                .availableResources(inventoryRequest.getAvailableResources())
                .maxOfferAmount(aggregateBidOfferDTO.getMaxOfferAmount())
                .minOfferAmount(aggregateBidOfferDTO.getMinOfferAmount())
                .avgOfferAmount(aggregateBidOfferDTO.getAvgOfferAmount())
                .build();
    }
}
