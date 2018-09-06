package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriesEntity {
    private int id;
    private String name;
    private String description;
    private Integer admId;
    private Integer createdDate;
    private Integer updatedDate;
    private Integer status;
    private String imagePreview;
    private Integer isRecommended;
    private Integer viewCount;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "adm_id", nullable = true)
    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
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

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "image_preview", nullable = true, length = 50)
    public String getImagePreview() {
        return imagePreview;
    }

    public void setImagePreview(String imagePreview) {
        this.imagePreview = imagePreview;
    }

    @Basic
    @Column(name = "is_recommended", nullable = true)
    public Integer getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(Integer isRecommended) {
        this.isRecommended = isRecommended;
    }

    @Basic
    @Column(name = "view_count", nullable = true)
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesEntity that = (CategoriesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(admId, that.admId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updatedDate, that.updatedDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(imagePreview, that.imagePreview) &&
                Objects.equals(isRecommended, that.isRecommended) &&
                Objects.equals(viewCount, that.viewCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, admId, createdDate, updatedDate, status, imagePreview, isRecommended, viewCount);
    }
}
