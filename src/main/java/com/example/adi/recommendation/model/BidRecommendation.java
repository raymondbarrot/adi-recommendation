package com.example.adi.recommendation.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidRecommendation {
    private String code;
    private String name;
    private Integer availableResources;
    private Double maxOfferAmount;
    private Double minOfferAmount;
    private Double avgOfferAmount;
}
