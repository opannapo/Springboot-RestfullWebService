package com.lamaknyo.api.services;

import com.lamaknyo.api.domain.UsersEntity;
import com.lamaknyo.api.common.FilterDto;

import java.util.Optional;

public interface UserService {
    Optional user(FilterDto filterDto);

    UsersEntity auth(FilterDto filterDto);

    Optional updateBasic(FilterDto filterDto);
}
