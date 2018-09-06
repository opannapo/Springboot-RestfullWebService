package com.lamaknyo.api.repository;

import com.lamaknyo.api.domain.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long>, JpaSpecificationExecutor<ProductsEntity> {
}