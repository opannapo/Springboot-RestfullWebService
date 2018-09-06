package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersEntity {
    private int id;
    private String name;
    private Integer gender;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer status;
    private Integer addrId;
    private Integer lastLogedin;
    private Integer joinDate;
    private String photo;
    private String bio;
    private String token;
    private Integer loginStatus;
    private int updatedDate;
    private AddressesEntity address;

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
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "addr_id", nullable = true)
    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    @Basic
    @Column(name = "last_logedin", nullable = true)
    public Integer getLastLogedin() {
        return lastLogedin;
    }

    public void setLastLogedin(Integer lastLogedin) {
        this.lastLogedin = lastLogedin;
    }

    @Basic
    @Column(name = "join_date", nullable = true)
    public Integer getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Integer joinDate) {
        this.joinDate = joinDate;
    }

    @Basic
    @Column(name = "photo", nullable = true, length = 100)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "bio", nullable = true, length = 100)
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Basic
    @Column(name = "login_status", nullable = true)
    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Basic
    @Column(name = "updated_date", nullable = false)
    public int getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(int updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addr_id", nullable = false, insertable = false, updatable = false)
    public AddressesEntity getAddress() {
        return address;
    }

    public void setAddress(AddressesEntity address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(status, that.status) &&
                Objects.equals(addrId, that.addrId) &&
                Objects.equals(lastLogedin, that.lastLogedin) &&
                Objects.equals(joinDate, that.joinDate) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(loginStatus, that.loginStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, gender, username, password, email, phone, status, addrId, lastLogedin, joinDate, photo, loginStatus);
    }

}
