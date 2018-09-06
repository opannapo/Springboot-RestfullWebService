package com.lamaknyo.api.repository;

import com.lamaknyo.api.domain.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity> {
}