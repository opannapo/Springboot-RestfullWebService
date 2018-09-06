package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "lamaknyo_dabe", catalog = "")
public class OrdersEntity {
    private int id;
    private String publishOrderCode;
    private Integer usrId;
    private Integer prdId;
    private Integer processingTimeEstimate;
    private Integer amountBuy;
    private Integer quantity;
    private String userNote;
    private String sellerNote;
    private Integer ordSttsId;
    private Integer ordSttsStpId;
    private Integer createdDate;
    private Integer updatedDate;
    private Integer sellerApprovedDate;
    private Integer buyerApprovedDate;
    private Integer paymentConfirmDate;
    private Integer paymentRejectDate;
    private Integer paymentVerifiedDate;
    private Integer processingDate;
    private Integer completedDate;
    private Integer canceledDate;
    private Integer canceledBy;
    private String canceledMessage;
    private String address;
    private String phone;
    private Integer ctyId;
    private Integer cntryId;
    private Integer prvnId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "publish_order_code", nullable = true, length = 50)
    public String getPublishOrderCode() {
        return publishOrderCode;
    }

    public void setPublishOrderCode(String publishOrderCode) {
        this.publishOrderCode = publishOrderCode;
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
    @Column(name = "prd_id", nullable = true)
    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    @Basic
    @Column(name = "processing_time_estimate", nullable = true)
    public Integer getProcessingTimeEstimate() {
        return processingTimeEstimate;
    }

    public void setProcessingTimeEstimate(Integer processingTimeEstimate) {
        this.processingTimeEstimate = processingTimeEstimate;
    }

    @Basic
    @Column(name = "amount_buy", nullable = true)
    public Integer getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(Integer amountBuy) {
        this.amountBuy = amountBuy;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "user_note", nullable = true, length = -1)
    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Basic
    @Column(name = "seller_note", nullable = true, length = -1)
    public String getSellerNote() {
        return sellerNote;
    }

    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
    }

    @Basic
    @Column(name = "ord_stts_id", nullable = true)
    public Integer getOrdSttsId() {
        return ordSttsId;
    }

    public void setOrdSttsId(Integer ordSttsId) {
        this.ordSttsId = ordSttsId;
    }

    @Basic
    @Column(name = "ord_stts_stp_id", nullable = true)
    public Integer getOrdSttsStpId() {
        return ordSttsStpId;
    }

    public void setOrdSttsStpId(Integer ordSttsStpId) {
        this.ordSttsStpId = ordSttsStpId;
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
    @Column(name = "seller_approved_date", nullable = true)
    public Integer getSellerApprovedDate() {
        return sellerApprovedDate;
    }

    public void setSellerApprovedDate(Integer sellerApprovedDate) {
        this.sellerApprovedDate = sellerApprovedDate;
    }

    @Basic
    @Column(name = "buyer_approved_date", nullable = true)
    public Integer getBuyerApprovedDate() {
        return buyerApprovedDate;
    }

    public void setBuyerApprovedDate(Integer buyerApprovedDate) {
        this.buyerApprovedDate = buyerApprovedDate;
    }

    @Basic
    @Column(name = "payment_confirm_date", nullable = true)
    public Integer getPaymentConfirmDate() {
        return paymentConfirmDate;
    }

    public void setPaymentConfirmDate(Integer paymentConfirmDate) {
        this.paymentConfirmDate = paymentConfirmDate;
    }

    @Basic
    @Column(name = "payment_reject_date", nullable = true)
    public Integer getPaymentRejectDate() {
        return paymentRejectDate;
    }

    public void setPaymentRejectDate(Integer paymentRejectDate) {
        this.paymentRejectDate = paymentRejectDate;
    }

    @Basic
    @Column(name = "payment_verified_date", nullable = true)
    public Integer getPaymentVerifiedDate() {
        return paymentVerifiedDate;
    }

    public void setPaymentVerifiedDate(Integer paymentVerifiedDate) {
        this.paymentVerifiedDate = paymentVerifiedDate;
    }

    @Basic
    @Column(name = "processing_date", nullable = true)
    public Integer getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Integer processingDate) {
        this.processingDate = processingDate;
    }

    @Basic
    @Column(name = "completed_date", nullable = true)
    public Integer getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Integer completedDate) {
        this.completedDate = completedDate;
    }

    @Basic
    @Column(name = "canceled_date", nullable = true)
    public Integer getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(Integer canceledDate) {
        this.canceledDate = canceledDate;
    }

    @Basic
    @Column(name = "canceled_by", nullable = true)
    public Integer getCanceledBy() {
        return canceledBy;
    }

    public void setCanceledBy(Integer canceledBy) {
        this.canceledBy = canceledBy;
    }

    @Basic
    @Column(name = "canceled_message", nullable = true, length = 500)
    public String getCanceledMessage() {
        return canceledMessage;
    }

    public void setCanceledMessage(String canceledMessage) {
        this.canceledMessage = canceledMessage;
    }

    @Basic
    @Column(name = "address", nullable = true, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "cty_id", nullable = true)
    public Integer getCtyId() {
        return ctyId;
    }

    public void setCtyId(Integer ctyId) {
        this.ctyId = ctyId;
    }

    @Basic
    @Column(name = "cntry_id", nullable = true)
    public Integer getCntryId() {
        return cntryId;
    }

    public void setCntryId(Integer cntryId) {
        this.cntryId = cntryId;
    }

    @Basic
    @Column(name = "prvn_id", nullable = true)
    public Integer getPrvnId() {
        return prvnId;
    }

    public void setPrvnId(Integer prvnId) {
        this.prvnId = prvnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id &&
                Objects.equals(publishOrderCode, that.publishOrderCode) &&
                Objects.equals(usrId, that.usrId) &&
                Objects.equals(prdId, that.prdId) &&
                Objects.equals(processingTimeEstimate, that.processingTimeEstimate) &&
                Objects.equals(amountBuy, that.amountBuy) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(userNote, that.userNote) &&
                Objects.equals(sellerNote, that.sellerNote) &&
                Objects.equals(ordSttsId, that.ordSttsId) &&
                Objects.equals(ordSttsStpId, that.ordSttsStpId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updatedDate, that.updatedDate) &&
                Objects.equals(sellerApprovedDate, that.sellerApprovedDate) &&
                Objects.equals(buyerApprovedDate, that.buyerApprovedDate) &&
                Objects.equals(paymentConfirmDate, that.paymentConfirmDate) &&
                Objects.equals(paymentRejectDate, that.paymentRejectDate) &&
                Objects.equals(paymentVerifiedDate, that.paymentVerifiedDate) &&
                Objects.equals(processingDate, that.processingDate) &&
                Objects.equals(completedDate, that.completedDate) &&
                Objects.equals(canceledDate, that.canceledDate) &&
                Objects.equals(canceledBy, that.canceledBy) &&
                Objects.equals(canceledMessage, that.canceledMessage) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(ctyId, that.ctyId) &&
                Objects.equals(cntryId, that.cntryId) &&
                Objects.equals(prvnId, that.prvnId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, publishOrderCode, usrId, prdId, processingTimeEstimate, amountBuy, quantity, userNote, sellerNote, ordSttsId, ordSttsStpId, createdDate, updatedDate, sellerApprovedDate, buyerApprovedDate, paymentConfirmDate, paymentRejectDate, paymentVerifiedDate, processingDate, completedDate, canceledDate, canceledBy, canceledMessage, address, phone, ctyId, cntryId, prvnId);
    }
}
