package com.lamaknyo.api.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"catId", "sllrId"})
public class ProductsEntity {
    private int id;
    private int catId;
    private int createdDate;
    private String description;
    private String foodIngredients;
    private int isExclusive;
    private int isPromotion;
    private int orderType;
    private int price;
    private int processingTimeEstimate;
    private int sllrId;
    private int status;
    private String title;
    private int updatedDate;
    private int viewCount;
    private int weight;
    private SellersEntity seller;
    private List<ProductImagesEntity> images = new ArrayList<>();
    private CategoriesEntity category;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cat_id", nullable = false)
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "created_date", nullable = false)
    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "food_ingredients", nullable = true, length = 255)
    public String getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(String foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    @Basic
    @Column(name = "is_exclusive", nullable = false)
    public int getIsExclusive() {
        return isExclusive;
    }

    public void setIsExclusive(int isExclusive) {
        this.isExclusive = isExclusive;
    }

    @Basic
    @Column(name = "is_promotion", nullable = false)
    public int getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(int isPromotion) {
        this.isPromotion = isPromotion;
    }

    @Basic
    @Column(name = "order_type", nullable = false)
    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "processing_time_estimate", nullable = false)
    public int getProcessingTimeEstimate() {
        return processingTimeEstimate;
    }

    public void setProcessingTimeEstimate(int processingTimeEstimate) {
        this.processingTimeEstimate = processingTimeEstimate;
    }

    @Basic
    @Column(name = "sllr_id", nullable = false)
    public int getSllrId() {
        return sllrId;
    }

    public void setSllrId(int sllrId) {
        this.sllrId = sllrId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "updated_date", nullable = false)
    public int getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(int updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "view_count", nullable = false)
    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sllr_id", nullable = false, insertable = false, updatable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SellersEntity getSeller() {
        return seller;
    }

    public void setSeller(SellersEntity seller) {
        this.seller = seller;
    }

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties({"prdId", "createdDate", "updatedDate"})
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ProductImagesEntity> getImages() {
        return images;
    }

    public void setImages(List<ProductImagesEntity> images) {
        this.images = images;
    }


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cat_id", nullable = false, insertable = false, updatable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return id == that.id &&
                catId == that.catId &&
                createdDate == that.createdDate &&
                isExclusive == that.isExclusive &&
                isPromotion == that.isPromotion &&
                orderType == that.orderType &&
                price == that.price &&
                processingTimeEstimate == that.processingTimeEstimate &&
                sllrId == that.sllrId &&
                status == that.status &&
                updatedDate == that.updatedDate &&
                viewCount == that.viewCount &&
                weight == that.weight &&
                Objects.equals(description, that.description) &&
                Objects.equals(foodIngredients, that.foodIngredients) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, catId, createdDate, description, foodIngredients, isExclusive, isPromotion, orderType, price, processingTimeEstimate, sllrId, status, title, updatedDate, viewCount, weight);
    }
}
