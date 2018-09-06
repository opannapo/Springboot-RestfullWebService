package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_reviews", schema = "lamaknyo_dabe", catalog = "")
public class ProductReviewsEntity {
    private int id;
    private Integer prdId;
    private Integer usrId;
    private Integer rating;
    private String message;
    private Integer msgParentId;
    private Integer status;
    private Integer createdDate;

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
    @Column(name = "usr_id", nullable = true)
    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "rating", nullable = true)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 100)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "msg_parent_id", nullable = true)
    public Integer getMsgParentId() {
        return msgParentId;
    }

    public void setMsgParentId(Integer msgParentId) {
        this.msgParentId = msgParentId;
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
    @Column(name = "created_date", nullable = true)
    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReviewsEntity that = (ProductReviewsEntity) o;
        return id == that.id &&
                Objects.equals(prdId, that.prdId) &&
                Objects.equals(usrId, that.usrId) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(message, that.message) &&
                Objects.equals(msgParentId, that.msgParentId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, prdId, usrId, rating, message, msgParentId, status, createdDate);
    }
}
