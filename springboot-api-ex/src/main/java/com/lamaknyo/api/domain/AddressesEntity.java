package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AddressesEntity {
    private int id;
    private int ctyId;
    private int araId;
    private int prvnId;
    private int cntryId;
    private String name;
    private String phone;
    private int updatedDate;
    private int createdDate;
    private LocCitiesEntity city;
    private LocAreasEntity area;
    private LocProvincesEntity province;
    private LocCountriesEntity country;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cty_id", nullable = false)
    public int getCtyId() {
        return ctyId;
    }

    public void setCtyId(int ctyId) {
        this.ctyId = ctyId;
    }

    @Basic
    @Column(name = "ara_id", nullable = false)
    public int getAraId() {
        return araId;
    }

    public void setAraId(int araId) {
        this.araId = araId;
    }

    @Basic
    @Column(name = "prvn_id", nullable = false)
    public int getPrvnId() {
        return prvnId;
    }

    public void setPrvnId(int prvnId) {
        this.prvnId = prvnId;
    }

    @Basic
    @Column(name = "cntry_id", nullable = false)
    public int getCntryId() {
        return cntryId;
    }

    public void setCntryId(int cntryId) {
        this.cntryId = cntryId;
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
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "updated_date", nullable = false)
    public int getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(int updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "created_date", nullable = false)
    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cty_id", nullable = false, insertable = false, updatable = false)
    public LocCitiesEntity getCity() {
        return city;
    }

    public void setCity(LocCitiesEntity city) {
        this.city = city;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ara_id", nullable = false, insertable = false, updatable = false)
    public LocAreasEntity getArea() {
        return area;
    }

    public void setArea(LocAreasEntity area) {
        this.area = area;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prvn_id", nullable = false, insertable = false, updatable = false)
    public LocProvincesEntity getProvince() {
        return province;
    }

    public void setProvince(LocProvincesEntity province) {
        this.province = province;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cntry_id", nullable = false, insertable = false, updatable = false)
    public LocCountriesEntity getCountry() {
        return country;
    }

    public void setCountry(LocCountriesEntity country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressesEntity that = (AddressesEntity) o;
        return id == that.id &&
                ctyId == that.ctyId &&
                araId == that.araId &&
                prvnId == that.prvnId &&
                cntryId == that.cntryId &&
                updatedDate == that.updatedDate &&
                createdDate == that.createdDate &&
                Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ctyId, araId, prvnId, cntryId, name, phone, updatedDate, createdDate);
    }
}
