package com.lamaknyo.api.repository.predicate;

import com.lamaknyo.api.domain.*;

import javax.persistence.criteria.*;

public class SellerPredicate extends BasePredicate {

    public Predicate findAllStatusActive() {
        query.where(
                builder.equal(root.get("status"), 1)
        ).orderBy(builder.asc(root.get("id"))).distinct(true);
        return result();
    }

    public Predicate findByFilter() {
        Join<SellersEntity, AddressesEntity> addr = root.join("address");
        Join<AddressesEntity, LocCitiesEntity> city = addr.join("city");
        Join<AddressesEntity, LocAreasEntity> area = addr.join("area");
        Join<AddressesEntity, LocProvincesEntity> province = addr.join("province");

        query.where(
                builder.equal(root.get("status"), 1),
                builder.like(root.get("name"), "%" + getFilter().get("name") + "%"),
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