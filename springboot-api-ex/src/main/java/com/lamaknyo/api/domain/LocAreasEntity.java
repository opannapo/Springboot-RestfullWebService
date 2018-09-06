package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "loc_areas", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LocAreasEntity {
    private int id;
    private String name;
    private int ctyId;
    private String araJneCode;
    private String araJneId;
    private String araJneCodeId;
    private Integer araDatetimeInsert;
    private Integer araDatetimeUpdate;
    private Integer araDatetimeDelete;
    private Integer araAduIdInsert;
    private Integer araAduIdUpdate;
    private Integer araAduIdDelete;
    private Integer araStatus;

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
    @Column(name = "cty_id", nullable = false)
    public int getCtyId() {
        return ctyId;
    }

    public void setCtyId(int ctyId) {
        this.ctyId = ctyId;
    }

    @Basic
    @Column(name = "ara_jne_code", nullable = true, length = 100)
    public String getAraJneCode() {
        return araJneCode;
    }

    public void setAraJneCode(String araJneCode) {
        this.araJneCode = araJneCode;
    }

    @Basic
    @Column(name = "ara_jne_id", nullable = true, length = 100)
    public String getAraJneId() {
        return araJneId;
    }

    public void setAraJneId(String araJneId) {
        this.araJneId = araJneId;
    }

    @Basic
    @Column(name = "ara_jne_code_id", nullable = true, length = 100)
    public String getAraJneCodeId() {
        return araJneCodeId;
    }

    public void setAraJneCodeId(String araJneCodeId) {
        this.araJneCodeId = araJneCodeId;
    }

    @Basic
    @Column(name = "ara_datetime_insert", nullable = true)
    public Integer getAraDatetimeInsert() {
        return araDatetimeInsert;
    }

    public void setAraDatetimeInsert(Integer araDatetimeInsert) {
        this.araDatetimeInsert = araDatetimeInsert;
    }

    @Basic
    @Column(name = "ara_datetime_update", nullable = true)
    public Integer getAraDatetimeUpdate() {
        return araDatetimeUpdate;
    }

    public void setAraDatetimeUpdate(Integer araDatetimeUpdate) {
        this.araDatetimeUpdate = araDatetimeUpdate;
    }

    @Basic
    @Column(name = "ara_datetime_delete", nullable = true)
    public Integer getAraDatetimeDelete() {
        return araDatetimeDelete;
    }

    public void setAraDatetimeDelete(Integer araDatetimeDelete) {
        this.araDatetimeDelete = araDatetimeDelete;
    }

    @Basic
    @Column(name = "ara_adu_id_insert", nullable = true)
    public Integer getAraAduIdInsert() {
        return araAduIdInsert;
    }

    public void setAraAduIdInsert(Integer araAduIdInsert) {
        this.araAduIdInsert = araAduIdInsert;
    }

    @Basic
    @Column(name = "ara_adu_id_update", nullable = true)
    public Integer getAraAduIdUpdate() {
        return araAduIdUpdate;
    }

    public void setAraAduIdUpdate(Integer araAduIdUpdate) {
        this.araAduIdUpdate = araAduIdUpdate;
    }

    @Basic
    @Column(name = "ara_adu_id_delete", nullable = true)
    public Integer getAraAduIdDelete() {
        return araAduIdDelete;
    }

    public void setAraAduIdDelete(Integer araAduIdDelete) {
        this.araAduIdDelete = araAduIdDelete;
    }

    @Basic
    @Column(name = "ara_status", nullable = true)
    public Integer getAraStatus() {
        return araStatus;
    }

    public void setAraStatus(Integer araStatus) {
        this.araStatus = araStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocAreasEntity that = (LocAreasEntity) o;
        return id == that.id &&
                ctyId == that.ctyId &&
                Objects.equals(name, that.name) &&
                Objects.equals(araJneCode, that.araJneCode) &&
                Objects.equals(araJneId, that.araJneId) &&
                Objects.equals(araJneCodeId, that.araJneCodeId) &&
                Objects.equals(araDatetimeInsert, that.araDatetimeInsert) &&
                Objects.equals(araDatetimeUpdate, that.araDatetimeUpdate) &&
                Objects.equals(araDatetimeDelete, that.araDatetimeDelete) &&
                Objects.equals(araAduIdInsert, that.araAduIdInsert) &&
                Objects.equals(araAduIdUpdate, that.araAduIdUpdate) &&
                Objects.equals(araAduIdDelete, that.araAduIdDelete) &&
                Objects.equals(araStatus, that.araStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, ctyId, araJneCode, araJneId, araJneCodeId, araDatetimeInsert, araDatetimeUpdate, araDatetimeDelete, araAduIdInsert, araAduIdUpdate, araAduIdDelete, araStatus);
    }
}
