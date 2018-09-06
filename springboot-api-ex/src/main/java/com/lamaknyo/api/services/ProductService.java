package com.lamaknyo.api.services;

import com.lamaknyo.api.domain.ProductsEntity;
import com.lamaknyo.api.common.FilterDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {
    Optional product(FilterDto filterDto);

    Page<ProductsEntity> productsActive(int page, int limit);

    Page<ProductsEntity> productsFilter(FilterDto filterDto, int page, int limit);

    Page<ProductsEntity> productsOfSeller(FilterDto filterDto, int page, int limit);

    Page<ProductsEntity> productsOfCategory(FilterDto filterDto, int page, int limit);

    Page<ProductsEntity> productsExclusive(int page, int limit);

    Page<ProductsEntity> productsPromotion(int page, int limit);

    Page<ProductsEntity> productsTop(int page, int limit);


}
