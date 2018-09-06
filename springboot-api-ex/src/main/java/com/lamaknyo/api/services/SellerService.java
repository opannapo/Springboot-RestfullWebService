package com.lamaknyo.api.services;

import com.lamaknyo.api.common.FilterDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface SellerService {
    Optional seller(FilterDto filterDto);

    Page sellersActive(int page, int limit);

    Page sellersFilter(FilterDto filterDto, int page, int limit);


}
