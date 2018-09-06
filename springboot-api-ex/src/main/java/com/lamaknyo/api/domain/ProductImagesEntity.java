package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lamaknyo.api.common.ResComponent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_images", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductImagesEntity {
    private int id;
    private Integer prdId;
    private String url;
    private Integer createdDate;
    private Integer updatedDate;
    private ProductsEntity product;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prd_id", nullable = true)
    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 100)
    public String getUrl() {
        return ResComponent.productUrl + getPrdId() + "/" + url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "created_date", nullable = true)
    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "updated_date", nullable = true)
    public Integer getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Integer updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImagesEntity that = (ProductImagesEntity) o;
        return id == that.id &&
                Objects.equals(prdId, that.prdId) &&
                Objects.equals(url, that.url) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updatedDate, that.updatedDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, prdId, url, createdDate, updatedDate);
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prd_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }
}
