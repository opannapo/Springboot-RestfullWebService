package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "banks", schema = "lamaknyo_dabe", catalog = "")
public class BanksEntity {
    private int id;
    private String no;
    private String name;
    private String desc;
    private String owner;
    private Integer status;
    private String icon;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "no", nullable = true, length = 30)
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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
    @Column(name = "desc", nullable = true, length = 100)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "owner", nullable = true, length = 30)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
    @Column(name = "icon", nullable = true, length = 30)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BanksEntity that = (BanksEntity) o;
        return id == that.id &&
                Objects.equals(no, that.no) &&
                Objects.equals(name, that.name) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(status, that.status) &&
                Objects.equals(icon, that.icon);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, no, name, desc, owner, status, icon);
    }
}
