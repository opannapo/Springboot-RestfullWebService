package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_messages", schema = "lamaknyo_dabe", catalog = "")
public class OrderMessagesEntity {
    private int id;
    private Integer ordId;
    private Integer userType;
    private String text;
    private Integer createdDate;
    private String action;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ord_id", nullable = true)
    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    @Basic
    @Column(name = "user_type", nullable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "text", nullable = true, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
    @Column(name = "action", nullable = true, length = -1)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMessagesEntity that = (OrderMessagesEntity) o;
        return id == that.id &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(text, that.text) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ordId, userType, text, createdDate, action);
    }
}
