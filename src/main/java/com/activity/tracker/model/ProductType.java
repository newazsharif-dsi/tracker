package com.activity.tracker.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_type")
public class ProductType implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "has_amount")
    private Boolean hasAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHasAmount() {
        return hasAmount;
    }

    public void setHasAmount(Boolean hasAmount) {
        this.hasAmount = hasAmount;
    }
}

