package com.lamaknyo.api.services.impl;

import com.lamaknyo.api.domain.*;
import com.lamaknyo.api.repository.ProductRepository;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repo;

    @Override
    public Optional product(FilterDto filterDto) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller");
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("id"), filterDto.get("id")),
                    builder.equal(seller.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        return repo.findOne(spec);
    }

    @Override
    public Page<ProductsEntity> productsActive(int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(seller.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        //return repo.findAll(spec, PageRequest.of(page - 1, limit));
        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
        return productsEntities;
    }

    @Override
    public Page<ProductsEntity> productsFilter(FilterDto filterDto, int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller");
            Join<SellersEntity, AddressesEntity> addr = seller.join("address");
            Join<AddressesEntity, LocCitiesEntity> city = addr.join("city");
            Join<AddressesEntity, LocAreasEntity> area = addr.join("area");
            Join<AddressesEntity, LocProvincesEntity> province = addr.join("province");
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.like(root.get("title"), "%" + filterDto.get("name") + "%"),
                    builder.or(
                            builder.like(addr.get("name"), "%" + filterDto.get("address") + "%"),
                            builder.like(city.get("name"), "%" + filterDto.get("address") + "%"),
                            builder.like(area.get("name"), "%" + filterDto.get("address") + "%"),
                            builder.like(province.get("name"), "%" + filterDto.get("address") + "%")
                    )
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        //return repo.findAll(spec, PageRequest.of(page - 1, limit));
        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
        return productsEntities;
    }

    @Override
    public Page<ProductsEntity> productsOfSeller(FilterDto filterDto, int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("sllrId"), filterDto.get("sellerId"))
            ).orderBy(builder.asc(root.get("id"))).distinct(true);

            return query.getGroupRestriction();
        };

        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.setSeller(null));
        return productsEntities;
    }

    @Override
    public Page<ProductsEntity> productsOfCategory(FilterDto filterDto, int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("catId"), filterDto.get("catId")),
                    builder.equal(seller.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);

            return query.getGroupRestriction();
        };

        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.setCategory(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
        return productsEntities;
    }

    @Override
    public Page<ProductsEntity> productsExclusive(int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("isExclusive"), 1),
                    builder.equal(seller.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
        return productsEntities;
    }

    @Override
    public Page<ProductsEntity> productsPromotion(int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("isPromotion"), 1),
                    builder.equal(seller.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
        return productsEntities;
    }

    @Override
    public Page<ProductsEntity> productsTop(int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(seller.get("status"), 1)
            ).orderBy(builder.asc(root.get("viewCount"))).distinct(true);
            return query.getGroupRestriction();
        };

        Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
        productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
        return productsEntities;
    }

}
