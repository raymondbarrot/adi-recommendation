package com.example.adi.recommendation.repository;

import com.example.adi.recommendation.entity.BidOffer;
import com.example.adi.recommendation.model.AggregateBidOfferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidOfferRepository extends JpaRepository<BidOffer, String> {

    @Query("SELECT new com.example.adi.recommendation.model.AggregateBidOfferDTO(MAX(amount), " +
            "MIN(amount),AVG(amount)) FROM bid_offer WHERE item_code =:itemCode")
    public AggregateBidOfferDTO findAggregateBidOfferDTOItemCode(@Param("itemCode") String itemCode);
}
