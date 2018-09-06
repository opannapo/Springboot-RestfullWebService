package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seller_shipments", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SellerShipmentsEntity {
    private int id;
    private int sllrId;
    private int shpmntId;
    private SellersEntity seller;
    private ShipmentsEntity shipping;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sllr_id", nullable = true)
    public int getSllrId() {
        return sllrId;
    }

    public void setSllrId(Integer sllrId) {
        this.sllrId = sllrId;
    }

    @Basic
    @Column(name = "shpmnt_id", nullable = true)
    public int getShpmntId() {
        return shpmntId;
    }

    public void setShpmntId(Integer shpmntId) {
        this.shpmntId = shpmntId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerShipmentsEntity that = (SellerShipmentsEntity) o;
        return id == that.id &&
                Objects.equals(sllrId, that.sllrId) &&
                Objects.equals(shpmntId, that.shpmntId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sllrId, shpmntId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sllr_id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public SellersEntity getSeller() {
        return seller;
    }

    public void setSeller(SellersEntity seller) {
        this.seller = seller;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shpmnt_id", nullable = true, insertable = false, updatable = false)
    public ShipmentsEntity getShipping() {
        return shipping;
    }

    public void setShipping(ShipmentsEntity shipping) {
        this.shipping = shipping;
    }
}
