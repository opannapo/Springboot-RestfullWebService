package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "messages", schema = "lamaknyo_dabe", catalog = "")
public class MessagesEntity {
    private int id;
    private Integer usrId;
    private String message;
    private Integer createdDate;
    private Integer status;
    private Integer userType;
    private UsersEntity user;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "usr_id", nullable = true)
    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "message", nullable = true, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "created_date", nullable = true)
    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
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
    @Column(name = "user_type", nullable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagesEntity that = (MessagesEntity) o;
        return id == that.id &&
                Objects.equals(usrId, that.usrId) &&
                Objects.equals(message, that.message) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(userType, that.userType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, usrId, message, createdDate, status, userType);
    }

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
