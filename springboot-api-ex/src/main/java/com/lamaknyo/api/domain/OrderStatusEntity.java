package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_status", schema = "lamaknyo_dabe", catalog = "")
public class OrderStatusEntity {
    private int id;
    private String statusDescription;
    private String message;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status_description", nullable = true, length = 30)
    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 100)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusEntity that = (OrderStatusEntity) o;
        return id == that.id &&
                Objects.equals(statusDescription, that.statusDescription) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, statusDescription, message);
    }
}
