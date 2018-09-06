package com.lamaknyo.api.services.impl;

import com.lamaknyo.api.domain.*;
import com.lamaknyo.api.repository.SellerRepository;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository repo;


    @Override
    public Optional seller(FilterDto filterDto) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("id"), filterDto.get("id"))
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        return repo.findOne(spec);
    }

    @Override
    public Page<SellersEntity> sellersActive(int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        return repo.findAll(spec, PageRequest.of(page - 1, limit));
    }

    @Override
    public Page<SellersEntity> sellersFilter(FilterDto filterDto, int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<SellersEntity, AddressesEntity> addr = root.join("address");
            Join<AddressesEntity, LocCitiesEntity> city = addr.join("city");
            Join<AddressesEntity, LocAreasEntity> area = addr.join("area");
            Join<AddressesEntity, LocProvincesEntity> province = addr.join("province");
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.like(root.get("name"), "%" + filterDto.get("name") + "%"),
                    builder.or(
                            builder.like(addr.get("name"), "%" + filterDto.get("address") + "%"),
                            builder.like(city.get("name"), "%" + filterDto.get("address") + "%"),
                            builder.like(area.get("name"), "%" + filterDto.get("address") + "%"),
                            builder.like(province.get("name"), "%" + filterDto.get("address") + "%")
                    )
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        return repo.findAll(spec, PageRequest.of(page - 1, limit));
    }
}
