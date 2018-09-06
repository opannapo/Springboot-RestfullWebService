package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_payment_detail", schema = "lamaknyo_dabe", catalog = "")
public class OrderPaymentDetailEntity {
    private int id;
    private Integer ordId;
    private Integer productBill;
    private Integer shipmentBill;
    private Integer amountBill;
    private Integer discount;
    private String discountNote;
    private String bankAccountNumber;
    private String bankName;
    private String bankOwnerName;
    private String targetBankAccountNumber;
    private String targetBankName;
    private String targetBankOwnerName;
    private Integer status;
    private String images;
    private Integer createdDate;
    private Integer approvedDate;
    private Integer rejectedDate;

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
    @Column(name = "product_bill", nullable = true)
    public Integer getProductBill() {
        return productBill;
    }

    public void setProductBill(Integer productBill) {
        this.productBill = productBill;
    }

    @Basic
    @Column(name = "shipment_bill", nullable = true)
    public Integer getShipmentBill() {
        return shipmentBill;
    }

    public void setShipmentBill(Integer shipmentBill) {
        this.shipmentBill = shipmentBill;
    }

    @Basic
    @Column(name = "amount_bill", nullable = true)
    public Integer getAmountBill() {
        return amountBill;
    }

    public void setAmountBill(Integer amountBill) {
        this.amountBill = amountBill;
    }

    @Basic
    @Column(name = "discount", nullable = true)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "discount_note", nullable = true, length = 100)
    public String getDiscountNote() {
        return discountNote;
    }

    public void setDiscountNote(String discountNote) {
        this.discountNote = discountNote;
    }

    @Basic
    @Column(name = "bank_account_number", nullable = true, length = 50)
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Basic
    @Column(name = "bank_name", nullable = true, length = 30)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bank_owner_name", nullable = true, length = 30)
    public String getBankOwnerName() {
        return bankOwnerName;
    }

    public void setBankOwnerName(String bankOwnerName) {
        this.bankOwnerName = bankOwnerName;
    }

    @Basic
    @Column(name = "target_bank_account_number", nullable = true, length = 50)
    public String getTargetBankAccountNumber() {
        return targetBankAccountNumber;
    }

    public void setTargetBankAccountNumber(String targetBankAccountNumber) {
        this.targetBankAccountNumber = targetBankAccountNumber;
    }

    @Basic
    @Column(name = "target_bank_name", nullable = true, length = 30)
    public String getTargetBankName() {
        return targetBankName;
    }

    public void setTargetBankName(String targetBankName) {
        this.targetBankName = targetBankName;
    }

    @Basic
    @Column(name = "target_bank_owner_name", nullable = true, length = 30)
    public String getTargetBankOwnerName() {
        return targetBankOwnerName;
    }

    public void setTargetBankOwnerName(String targetBankOwnerName) {
        this.targetBankOwnerName = targetBankOwnerName;
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
    @Column(name = "images", nullable = true, length = -1)
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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
    @Column(name = "approved_date", nullable = true)
    public Integer getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Integer approvedDate) {
        this.approvedDate = approvedDate;
    }

    @Basic
    @Column(name = "rejected_date", nullable = true)
    public Integer getRejectedDate() {
        return rejectedDate;
    }

    public void setRejectedDate(Integer rejectedDate) {
        this.rejectedDate = rejectedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPaymentDetailEntity that = (OrderPaymentDetailEntity) o;
        return id == that.id &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(productBill, that.productBill) &&
                Objects.equals(shipmentBill, that.shipmentBill) &&
                Objects.equals(amountBill, that.amountBill) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(discountNote, that.discountNote) &&
                Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(bankOwnerName, that.bankOwnerName) &&
                Objects.equals(targetBankAccountNumber, that.targetBankAccountNumber) &&
                Objects.equals(targetBankName, that.targetBankName) &&
                Objects.equals(targetBankOwnerName, that.targetBankOwnerName) &&
                Objects.equals(status, that.status) &&
                Objects.equals(images, that.images) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(approvedDate, that.approvedDate) &&
                Objects.equals(rejectedDate, that.rejectedDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ordId, productBill, shipmentBill, amountBill, discount, discountNote, bankAccountNumber, bankName, bankOwnerName, targetBankAccountNumber, targetBankName, targetBankOwnerName, status, images, createdDate, approvedDate, rejectedDate);
    }
}
