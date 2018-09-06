package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_message_bot", schema = "lamaknyo_dabe", catalog = "")
public class OrderMessageBotEntity {
    private int id;
    private Integer step;
    private String text;
    private String description;
    private String action;
    private String lang;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "step", nullable = true)
    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    @Basic
    @Column(name = "text", nullable = true, length = 200)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "action", nullable = true, length = -1)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "lang", nullable = true, length = 5)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMessageBotEntity that = (OrderMessageBotEntity) o;
        return id == that.id &&
                Objects.equals(step, that.step) &&
                Objects.equals(text, that.text) &&
                Objects.equals(description, that.description) &&
                Objects.equals(action, that.action) &&
                Objects.equals(lang, that.lang);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, step, text, description, action, lang);
    }
}
