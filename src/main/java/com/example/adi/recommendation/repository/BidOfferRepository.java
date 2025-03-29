package com.example.adi.recommendation.repository;

import com.example.adi.recommendation.entity.BidOffer;
import com.example.adi.recommendation.model.AggregateBidOfferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidOfferRepository extends JpaRepository<BidOffer, String> {

    @Query("SELECT new com.example.adi.recommendation.model.AggregateBidOfferDTO(MAX(b.amount), " +
            "MIN(b.amount), AVG(b.amount)) FROM BidOffer b WHERE b.itemCode =:itemCode")
    AggregateBidOfferDTO findAggregateBidOfferDTOItemCode(@Param("itemCode") String itemCode);

}
