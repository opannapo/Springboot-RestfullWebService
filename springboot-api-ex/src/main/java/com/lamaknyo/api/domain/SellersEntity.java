package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sellers", schema = "lamaknyo_dabe", catalog = "")
//@NamedEntityGraph(name = "SellersEntity.sellerShipment", attributeNodes = @NamedAttributeNode("sellerShipment"))
@NamedEntityGraph(
        name = "SellersEntity.address",
        attributeNodes = {
                @NamedAttributeNode(value = "address", subgraph = "addressGraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "addressGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "city"),
                                @NamedAttributeNode(value = "area"),
                                @NamedAttributeNode(value = "province"),
                                @NamedAttributeNode(value = "country")
                        }
                )
        })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SellersEntity {
    private int id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private int status;
    private int lastLogedin;
    private int addrId;
    private int joinDate;
    private int admId;
    private int updatedDate;
    private AddressesEntity address;
    private List<SellerShipmentsEntity> sellerShipment = new ArrayList<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "last_logedin", nullable = false)
    public int getLastLogedin() {
        return lastLogedin;
    }

    public void setLastLogedin(int lastLogedin) {
        this.lastLogedin = lastLogedin;
    }

    @Basic
    @Column(name = "addr_id", nullable = false)
    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    @Basic
    @Column(name = "join_date", nullable = false)
    public int getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(int joinDate) {
        this.joinDate = joinDate;
    }

    @Basic
    @Column(name = "adm_id", nullable = false)
    public int getAdmId() {
        return admId;
    }

    public void setAdmId(int admId) {
        this.admId = admId;
    }

    @Basic
    @Column(name = "updated_date", nullable = false)
    public int getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(int updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellersEntity that = (SellersEntity) o;
        return id == that.id &&
                status == that.status &&
                lastLogedin == that.lastLogedin &&
                addrId == that.addrId &&
                joinDate == that.joinDate &&
                admId == that.admId &&
                updatedDate == that.updatedDate &&
                Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, phone, status, lastLogedin, addrId, joinDate, admId, updatedDate);
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addr_id", nullable = false, insertable = false, updatable = false)
    public AddressesEntity getAddress() {
        return address;
    }

    public void setAddress(AddressesEntity address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "seller", orphanRemoval = true)
    @JsonManagedReference
    public List<SellerShipmentsEntity> getSellerShipment() {
        return sellerShipment;
    }

    public void setSellerShipment(List<SellerShipmentsEntity> sellerShipment) {
        this.sellerShipment = sellerShipment;
    }
}
