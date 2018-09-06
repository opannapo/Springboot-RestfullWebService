package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "areas_backup", schema = "lamaknyo_dabe", catalog = "")
public class AreasBackupEntity {
    private int id;
    private String name;
    private Integer ctyId;
    private Integer isCapital;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "is_capital", nullable = true)
    public Integer getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(Integer isCapital) {
        this.isCapital = isCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreasBackupEntity that = (AreasBackupEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(ctyId, that.ctyId) &&
                Objects.equals(isCapital, that.isCapital);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, ctyId, isCapital);
    }
}
