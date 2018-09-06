package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_region", schema = "lamaknyo_dabe", catalog = "")
public class TblRegionEntity {
    private int regId;
    private int regCnyId;
    private String regName;
    private Integer regDatetime;
    private Integer regDatetimeInsert;
    private Integer regDatetimeUpdate;
    private Integer regDatetimeDelete;
    private Integer regAduIdInsert;
    private Integer regAduIdUpdate;
    private Integer regAduIdDelete;
    private Integer regStatus;

    @Id
    @Column(name = "reg_id", nullable = false)
    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    @Basic
    @Column(name = "reg_cny_id", nullable = false)
    public int getRegCnyId() {
        return regCnyId;
    }

    public void setRegCnyId(int regCnyId) {
        this.regCnyId = regCnyId;
    }

    @Basic
    @Column(name = "reg_name", nullable = false, length = 100)
    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
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
        TblRegionEntity that = (TblRegionEntity) o;
        return regId == that.regId &&
                regCnyId == that.regCnyId &&
                Objects.equals(regName, that.regName) &&
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

        return Objects.hash(regId, regCnyId, regName, regDatetime, regDatetimeInsert, regDatetimeUpdate, regDatetimeDelete, regAduIdInsert, regAduIdUpdate, regAduIdDelete, regStatus);
    }
}
