package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins", schema = "lamaknyo_dabe", catalog = "")
public class AdminsEntity {
    private int id;
    private String name;
    private String username;
    private String password;
    private String photo;
    private Integer status;
    private Integer level;
    private Integer lastLogin;
    private Integer lastLogout;
    private Integer admAccsId;
    private Integer updatedDate;
    private Integer createdDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
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
    @Column(name = "photo", nullable = true, length = 50)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "last_login", nullable = true)
    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "last_logout", nullable = true)
    public Integer getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(Integer lastLogout) {
        this.lastLogout = lastLogout;
    }

    @Basic
    @Column(name = "adm_accs_id", nullable = true)
    public Integer getAdmAccsId() {
        return admAccsId;
    }

    public void setAdmAccsId(Integer admAccsId) {
        this.admAccsId = admAccsId;
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
    @Column(name = "created_date", nullable = true)
    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminsEntity that = (AdminsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(status, that.status) &&
                Objects.equals(level, that.level) &&
                Objects.equals(lastLogin, that.lastLogin) &&
                Objects.equals(lastLogout, that.lastLogout) &&
                Objects.equals(admAccsId, that.admAccsId) &&
                Objects.equals(updatedDate, that.updatedDate) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, username, password, photo, status, level, lastLogin, lastLogout, admAccsId, updatedDate, createdDate);
    }
}
