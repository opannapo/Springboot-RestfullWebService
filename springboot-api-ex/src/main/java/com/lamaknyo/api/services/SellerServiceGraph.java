package com.lamaknyo.api.services;

import com.lamaknyo.api.domain.SellersEntity;
import com.lamaknyo.api.common.FilterDto;
import org.springframework.data.domain.Page;

public interface SellerServiceGraph {
    SellersEntity seller(FilterDto filterDto);

    Page sellersActive(int page, int limit);

    Page sellersFilter(FilterDto filterDto, int page, int limit);


}
