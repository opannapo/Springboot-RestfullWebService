package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_status_step", schema = "lamaknyo_dabe", catalog = "")
public class OrderStatusStepEntity {
    private int id;
    private Integer stepKey;
    private Integer status;
    private Integer action;
    private String stepDescription;
    private String label;
    private String message;
    private String sellerMessage;
    private String buyerMessage;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "step_key", nullable = true)
    public Integer getStepKey() {
        return stepKey;
    }

    public void setStepKey(Integer stepKey) {
        this.stepKey = stepKey;
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
    @Column(name = "action", nullable = true)
    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    @Basic
    @Column(name = "step_description", nullable = true, length = 100)
    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    @Basic
    @Column(name = "label", nullable = true, length = 100)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
    @Column(name = "seller_message", nullable = true, length = 100)
    public String getSellerMessage() {
        return sellerMessage;
    }

    public void setSellerMessage(String sellerMessage) {
        this.sellerMessage = sellerMessage;
    }

    @Basic
    @Column(name = "buyer_message", nullable = true, length = 100)
    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusStepEntity that = (OrderStatusStepEntity) o;
        return id == that.id &&
                Objects.equals(stepKey, that.stepKey) &&
                Objects.equals(status, that.status) &&
                Objects.equals(action, that.action) &&
                Objects.equals(stepDescription, that.stepDescription) &&
                Objects.equals(label, that.label) &&
                Objects.equals(message, that.message) &&
                Objects.equals(sellerMessage, that.sellerMessage) &&
                Objects.equals(buyerMessage, that.buyerMessage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stepKey, status, action, stepDescription, label, message, sellerMessage, buyerMessage);
    }
}
