package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_promotion_rule_type", schema = "lamaknyo_dabe", catalog = "")
public class ProductPromotionRuleTypeEntity {
    private int id;
    private String label;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "label", nullable = true, length = 30)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPromotionRuleTypeEntity that = (ProductPromotionRuleTypeEntity) o;
        return id == that.id &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, label);
    }
}
