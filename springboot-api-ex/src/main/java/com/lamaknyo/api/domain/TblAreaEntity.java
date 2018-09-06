package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_area", schema = "lamaknyo_dabe", catalog = "")
public class TblAreaEntity {
    private int araId;
    private int araCitId;
    private String araName;
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
    @Column(name = "ara_id", nullable = false)
    public int getAraId() {
        return araId;
    }

    public void setAraId(int araId) {
        this.araId = araId;
    }

    @Basic
    @Column(name = "ara_cit_id", nullable = false)
    public int getAraCitId() {
        return araCitId;
    }

    public void setAraCitId(int araCitId) {
        this.araCitId = araCitId;
    }

    @Basic
    @Column(name = "ara_name", nullable = false, length = 100)
    public String getAraName() {
        return araName;
    }

    public void setAraName(String araName) {
        this.araName = araName;
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
        TblAreaEntity that = (TblAreaEntity) o;
        return araId == that.araId &&
                araCitId == that.araCitId &&
                Objects.equals(araName, that.araName) &&
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

        return Objects.hash(araId, araCitId, araName, araJneCode, araJneId, araJneCodeId, araDatetimeInsert, araDatetimeUpdate, araDatetimeDelete, araAduIdInsert, araAduIdUpdate, araAduIdDelete, araStatus);
    }
}
