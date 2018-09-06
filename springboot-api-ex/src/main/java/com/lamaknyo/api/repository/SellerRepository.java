package com.lamaknyo.api.repository;

import com.lamaknyo.api.domain.SellersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellersEntity, Long>, JpaSpecificationExecutor<SellersEntity> {
    /*
    Lebih lama pake EntityGraph, execute rata-rata beda sampai 10ms
    @EntityGraph(value = "SellersEntity.address", type = EntityGraphType.FETCH)
    Page<SellersEntity> findAll(Specification spec, Pageable pageable);
    */

    @Query("SELECT s FROM SellersEntity s WHERE s.status= :status")
    /*@Query("SELECT seller FROM SellersEntity seller " +
            "LEFT JOIN FETCH seller.sellerShipment sellerShipment WHERE seller.status= :status")*/
    Page<SellersEntity> findAllActive(@Param("status") int status, Pageable pageable);
}