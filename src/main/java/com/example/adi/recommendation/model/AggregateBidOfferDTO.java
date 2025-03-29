package com.example.adi.recommendation.model;

import lombok.*;

@Getter
@Setter
@Builder
public class AggregateBidOfferDTO {
    private Double maxOfferAmount;
    private Double minOfferAmount;
    private Double avgOfferAmount;

    public AggregateBidOfferDTO(Double maxOfferAmount, Double minOfferAmount, Double avgOfferAmount) {
        this.maxOfferAmount = maxOfferAmount;
        this.minOfferAmount = minOfferAmount;
        this.avgOfferAmount = avgOfferAmount;
    }
}
