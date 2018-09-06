package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_accesses", schema = "lamaknyo_dabe", catalog = "")
public class AdminAccessesEntity {
    private int id;
    private Integer updatedDate;
    private Byte sellerCreate;
    private Byte sellerEdit;
    private Byte adminCreate;
    private Byte adminEdit;
    private Byte notificationAll;
    private Byte notificationActiveUsers;
    private Byte notificationInactiveUsers;
    private Byte notificationProduct;
    private Byte notificationCategory;
    private Byte notificationPlatform;
    private Byte notificationMember;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "seller_create", nullable = true)
    public Byte getSellerCreate() {
        return sellerCreate;
    }

    public void setSellerCreate(Byte sellerCreate) {
        this.sellerCreate = sellerCreate;
    }

    @Basic
    @Column(name = "seller_edit", nullable = true)
    public Byte getSellerEdit() {
        return sellerEdit;
    }

    public void setSellerEdit(Byte sellerEdit) {
        this.sellerEdit = sellerEdit;
    }

    @Basic
    @Column(name = "admin_create", nullable = true)
    public Byte getAdminCreate() {
        return adminCreate;
    }

    public void setAdminCreate(Byte adminCreate) {
        this.adminCreate = adminCreate;
    }

    @Basic
    @Column(name = "admin_edit", nullable = true)
    public Byte getAdminEdit() {
        return adminEdit;
    }

    public void setAdminEdit(Byte adminEdit) {
        this.adminEdit = adminEdit;
    }

    @Basic
    @Column(name = "notification_all", nullable = true)
    public Byte getNotificationAll() {
        return notificationAll;
    }

    public void setNotificationAll(Byte notificationAll) {
        this.notificationAll = notificationAll;
    }

    @Basic
    @Column(name = "notification_active_users", nullable = true)
    public Byte getNotificationActiveUsers() {
        return notificationActiveUsers;
    }

    public void setNotificationActiveUsers(Byte notificationActiveUsers) {
        this.notificationActiveUsers = notificationActiveUsers;
    }

    @Basic
    @Column(name = "notification_inactive_users", nullable = true)
    public Byte getNotificationInactiveUsers() {
        return notificationInactiveUsers;
    }

    public void setNotificationInactiveUsers(Byte notificationInactiveUsers) {
        this.notificationInactiveUsers = notificationInactiveUsers;
    }

    @Basic
    @Column(name = "notification_product", nullable = true)
    public Byte getNotificationProduct() {
        return notificationProduct;
    }

    public void setNotificationProduct(Byte notificationProduct) {
        this.notificationProduct = notificationProduct;
    }

    @Basic
    @Column(name = "notification_category", nullable = true)
    public Byte getNotificationCategory() {
        return notificationCategory;
    }

    public void setNotificationCategory(Byte notificationCategory) {
        this.notificationCategory = notificationCategory;
    }

    @Basic
    @Column(name = "notification_platform", nullable = true)
    public Byte getNotificationPlatform() {
        return notificationPlatform;
    }

    public void setNotificationPlatform(Byte notificationPlatform) {
        this.notificationPlatform = notificationPlatform;
    }

    @Basic
    @Column(name = "notification_member", nullable = true)
    public Byte getNotificationMember() {
        return notificationMember;
    }

    public void setNotificationMember(Byte notificationMember) {
        this.notificationMember = notificationMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminAccessesEntity that = (AdminAccessesEntity) o;
        return id == that.id &&
                Objects.equals(updatedDate, that.updatedDate) &&
                Objects.equals(sellerCreate, that.sellerCreate) &&
                Objects.equals(sellerEdit, that.sellerEdit) &&
                Objects.equals(adminCreate, that.adminCreate) &&
                Objects.equals(adminEdit, that.adminEdit) &&
                Objects.equals(notificationAll, that.notificationAll) &&
                Objects.equals(notificationActiveUsers, that.notificationActiveUsers) &&
                Objects.equals(notificationInactiveUsers, that.notificationInactiveUsers) &&
                Objects.equals(notificationProduct, that.notificationProduct) &&
                Objects.equals(notificationCategory, that.notificationCategory) &&
                Objects.equals(notificationPlatform, that.notificationPlatform) &&
                Objects.equals(notificationMember, that.notificationMember);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, updatedDate, sellerCreate, sellerEdit, adminCreate, adminEdit, notificationAll, notificationActiveUsers, notificationInactiveUsers, notificationProduct, notificationCategory, notificationPlatform, notificationMember);
    }
}
