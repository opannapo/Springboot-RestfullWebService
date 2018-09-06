package com.lamaknyo.api.services;

import com.lamaknyo.api.common.FilterDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MessageService {
    Optional message(FilterDto filterDto);

    Page messageOfUser(FilterDto filterDto, int page, int limit);

    Page messageOfMe(FilterDto filterDto, int page, int limit);
}
