package com.lamaknyo.api.services.impl;

import com.lamaknyo.api.domain.SellersEntity;
import com.lamaknyo.api.repository.SellerRepository;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.SellerServiceGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class SellerServiceGraphImpl implements SellerServiceGraph {
    @Autowired
    SellerRepository repo;

    @PersistenceContext
    private EntityManager em;


    @Override
    public SellersEntity seller(FilterDto filterDto) {
        SellersEntity sellersEntity = em.find(SellersEntity.class, filterDto.get("id"));
        return sellersEntity;
    }


    @Override
    public Page<SellersEntity> sellersActive(int page, int limit) {
        return repo.findAllActive(1, PageRequest.of(page - 1, limit));

    }

    @Override
    public Page<SellersEntity> sellersFilter(FilterDto filterDto, int page, int limit) {
        return null;
    }
}
