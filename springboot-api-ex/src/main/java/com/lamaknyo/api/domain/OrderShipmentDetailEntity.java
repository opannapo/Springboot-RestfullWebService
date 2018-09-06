package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_shipment_detail", schema = "lamaknyo_dabe", catalog = "")
public class OrderShipmentDetailEntity {
    private int id;
    private Integer ordId;
    private Integer shpmntId;
    private Integer weight;
    private String addressStart;
    private Integer addressStartAraId;
    private Integer addressStartCtyId;
    private Integer addressStartPrvnId;
    private Integer addressStartCntryId;
    private String addressEnd;
    private Integer addressEndAraId;
    private Integer addressEndCtyId;
    private Integer addressEndPrvnId;
    private Integer addressEndCntryId;
    private Integer status;
    private String images;
    private Integer createdDate;
    private Integer deliveryDate;
    private Integer completedDate;
    private Integer canceledDate;
    private Integer amountPaid;
    private String note;

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
    @Column(name = "shpmnt_id", nullable = true)
    public Integer getShpmntId() {
        return shpmntId;
    }

    public void setShpmntId(Integer shpmntId) {
        this.shpmntId = shpmntId;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "address_start", nullable = true, length = -1)
    public String getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(String addressStart) {
        this.addressStart = addressStart;
    }

    @Basic
    @Column(name = "address_start_ara_id", nullable = true)
    public Integer getAddressStartAraId() {
        return addressStartAraId;
    }

    public void setAddressStartAraId(Integer addressStartAraId) {
        this.addressStartAraId = addressStartAraId;
    }

    @Basic
    @Column(name = "address_start_cty_id", nullable = true)
    public Integer getAddressStartCtyId() {
        return addressStartCtyId;
    }

    public void setAddressStartCtyId(Integer addressStartCtyId) {
        this.addressStartCtyId = addressStartCtyId;
    }

    @Basic
    @Column(name = "address_start_prvn_id", nullable = true)
    public Integer getAddressStartPrvnId() {
        return addressStartPrvnId;
    }

    public void setAddressStartPrvnId(Integer addressStartPrvnId) {
        this.addressStartPrvnId = addressStartPrvnId;
    }

    @Basic
    @Column(name = "address_start_cntry_id", nullable = true)
    public Integer getAddressStartCntryId() {
        return addressStartCntryId;
    }

    public void setAddressStartCntryId(Integer addressStartCntryId) {
        this.addressStartCntryId = addressStartCntryId;
    }

    @Basic
    @Column(name = "address_end", nullable = true, length = -1)
    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    @Basic
    @Column(name = "address_end_ara_id", nullable = true)
    public Integer getAddressEndAraId() {
        return addressEndAraId;
    }

    public void setAddressEndAraId(Integer addressEndAraId) {
        this.addressEndAraId = addressEndAraId;
    }

    @Basic
    @Column(name = "address_end_cty_id", nullable = true)
    public Integer getAddressEndCtyId() {
        return addressEndCtyId;
    }

    public void setAddressEndCtyId(Integer addressEndCtyId) {
        this.addressEndCtyId = addressEndCtyId;
    }

    @Basic
    @Column(name = "address_end_prvn_id", nullable = true)
    public Integer getAddressEndPrvnId() {
        return addressEndPrvnId;
    }

    public void setAddressEndPrvnId(Integer addressEndPrvnId) {
        this.addressEndPrvnId = addressEndPrvnId;
    }

    @Basic
    @Column(name = "address_end_cntry_id", nullable = true)
    public Integer getAddressEndCntryId() {
        return addressEndCntryId;
    }

    public void setAddressEndCntryId(Integer addressEndCntryId) {
        this.addressEndCntryId = addressEndCntryId;
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
    @Column(name = "delivery_date", nullable = true)
    public Integer getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Integer deliveryDate) {
        this.deliveryDate = deliveryDate;
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
    @Column(name = "amount_paid", nullable = true)
    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderShipmentDetailEntity that = (OrderShipmentDetailEntity) o;
        return id == that.id &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(shpmntId, that.shpmntId) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(addressStart, that.addressStart) &&
                Objects.equals(addressStartAraId, that.addressStartAraId) &&
                Objects.equals(addressStartCtyId, that.addressStartCtyId) &&
                Objects.equals(addressStartPrvnId, that.addressStartPrvnId) &&
                Objects.equals(addressStartCntryId, that.addressStartCntryId) &&
                Objects.equals(addressEnd, that.addressEnd) &&
                Objects.equals(addressEndAraId, that.addressEndAraId) &&
                Objects.equals(addressEndCtyId, that.addressEndCtyId) &&
                Objects.equals(addressEndPrvnId, that.addressEndPrvnId) &&
                Objects.equals(addressEndCntryId, that.addressEndCntryId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(images, that.images) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(completedDate, that.completedDate) &&
                Objects.equals(canceledDate, that.canceledDate) &&
                Objects.equals(amountPaid, that.amountPaid) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ordId, shpmntId, weight, addressStart, addressStartAraId, addressStartCtyId, addressStartPrvnId, addressStartCntryId, addressEnd, addressEndAraId, addressEndCtyId, addressEndPrvnId, addressEndCntryId, status, images, createdDate, deliveryDate, completedDate, canceledDate, amountPaid, note);
    }
}
