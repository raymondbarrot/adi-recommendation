package com.example.adi.recommendation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BidOffer {
    @Id
    private String bidId;
    private Double amount;
    private Integer numberOfResources;
	private String status;
	private String itemCode;
}
