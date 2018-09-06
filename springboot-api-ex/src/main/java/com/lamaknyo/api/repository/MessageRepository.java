package com.lamaknyo.api.repository;

import com.lamaknyo.api.domain.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessagesEntity, Long>, JpaSpecificationExecutor<MessagesEntity> {
}