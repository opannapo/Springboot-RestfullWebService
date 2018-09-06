package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "loc_provinces", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LocProvincesEntity {
    private int id;
    private String name;
    private int cntryId;
    private Integer isCapital;
    private Integer regDatetime;
    private Integer regDatetimeInsert;
    private Integer regDatetimeUpdate;
    private Integer regDatetimeDelete;
    private Integer regAduIdInsert;
    private Integer regAduIdUpdate;
    private Integer regAduIdDelete;
    private Integer regStatus;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "is_capital", nullable = true)
    public Integer getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(Integer isCapital) {
        this.isCapital = isCapital;
    }

    @Basic
    @Column(name = "reg_datetime", nullable = true)
    public Integer getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Integer regDatetime) {
        this.regDatetime = regDatetime;
    }

    @Basic
    @Column(name = "reg_datetime_insert", nullable = true)
    public Integer getRegDatetimeInsert() {
        return regDatetimeInsert;
    }

    public void setRegDatetimeInsert(Integer regDatetimeInsert) {
        this.regDatetimeInsert = regDatetimeInsert;
    }

    @Basic
    @Column(name = "reg_datetime_update", nullable = true)
    public Integer getRegDatetimeUpdate() {
        return regDatetimeUpdate;
    }

    public void setRegDatetimeUpdate(Integer regDatetimeUpdate) {
        this.regDatetimeUpdate = regDatetimeUpdate;
    }

    @Basic
    @Column(name = "reg_datetime_delete", nullable = true)
    public Integer getRegDatetimeDelete() {
        return regDatetimeDelete;
    }

    public void setRegDatetimeDelete(Integer regDatetimeDelete) {
        this.regDatetimeDelete = regDatetimeDelete;
    }

    @Basic
    @Column(name = "reg_adu_id_insert", nullable = true)
    public Integer getRegAduIdInsert() {
        return regAduIdInsert;
    }

    public void setRegAduIdInsert(Integer regAduIdInsert) {
        this.regAduIdInsert = regAduIdInsert;
    }

    @Basic
    @Column(name = "reg_adu_id_update", nullable = true)
    public Integer getRegAduIdUpdate() {
        return regAduIdUpdate;
    }

    public void setRegAduIdUpdate(Integer regAduIdUpdate) {
        this.regAduIdUpdate = regAduIdUpdate;
    }

    @Basic
    @Column(name = "reg_adu_id_delete", nullable = true)
    public Integer getRegAduIdDelete() {
        return regAduIdDelete;
    }

    public void setRegAduIdDelete(Integer regAduIdDelete) {
        this.regAduIdDelete = regAduIdDelete;
    }

    @Basic
    @Column(name = "reg_status", nullable = true)
    public Integer getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Integer regStatus) {
        this.regStatus = regStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocProvincesEntity that = (LocProvincesEntity) o;
        return id == that.id &&
                cntryId == that.cntryId &&
                Objects.equals(name, that.name) &&
                Objects.equals(isCapital, that.isCapital) &&
                Objects.equals(regDatetime, that.regDatetime) &&
                Objects.equals(regDatetimeInsert, that.regDatetimeInsert) &&
                Objects.equals(regDatetimeUpdate, that.regDatetimeUpdate) &&
                Objects.equals(regDatetimeDelete, that.regDatetimeDelete) &&
                Objects.equals(regAduIdInsert, that.regAduIdInsert) &&
                Objects.equals(regAduIdUpdate, that.regAduIdUpdate) &&
                Objects.equals(regAduIdDelete, that.regAduIdDelete) &&
                Objects.equals(regStatus, that.regStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, cntryId, isCapital, regDatetime, regDatetimeInsert, regDatetimeUpdate, regDatetimeDelete, regAduIdInsert, regAduIdUpdate, regAduIdDelete, regStatus);
    }
}
