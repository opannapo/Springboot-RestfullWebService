package com.lamaknyo.api.repository.predicate;

import com.lamaknyo.api.domain.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

public class ProductPredicate extends BasePredicate {

    public Predicate productsActive() {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);

        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(seller.get("status"), 1)
        ).orderBy(builder.asc(root.get("id"))).distinct(true);

        return result();
    }

    public Predicate product() {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller");
        Join<ProductsEntity, CategoriesEntity> cat = root.join("category");

        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(root.get("id"), getFilter().get("id")),
                builder.equal(seller.get("status"), 1),
                builder.equal(cat.get("id"), root.get("catId"))
        ).orderBy(builder.asc(root.get("id"))).distinct(true);
        return result();
    }

    public Predicate productsOfSeller() {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller");

        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(seller.get("id"), getFilter().get("sellerId"))
        ).orderBy(builder.asc(root.get("id"))).distinct(true);

        return result();
    }

    public Predicate productsFilter() {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller");
        Join<SellersEntity, AddressesEntity> addr = seller.join("address");
        Join<AddressesEntity, LocCitiesEntity> city = addr.join("city");
        Join<AddressesEntity, LocAreasEntity> area = addr.join("area");
        Join<AddressesEntity, LocProvincesEntity> province = addr.join("province");

        query.where(
                builder.equal(root.get("status"), 1),
                builder.like(root.get("title"), "%" + getFilter().get("name") + "%"),
                builder.or(
                        builder.like(addr.get("name"), "%" + getFilter().get("address") + "%"),
                        builder.like(city.get("name"), "%" + getFilter().get("address") + "%"),
                        builder.like(area.get("name"), "%" + getFilter().get("address") + "%"),
                        builder.like(province.get("name"), "%" + getFilter().get("address") + "%")
                )
        ).orderBy(builder.asc(root.get("id"))).distinct(true);

        return result();
    }
}