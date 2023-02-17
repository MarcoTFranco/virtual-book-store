package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Double percentage;
    private Date validity;

    public Coupon(String code, Double percentage, Date validity) {
        this.code = code;
        this.percentage = percentage;
        this.validity = validity;
    }

    public String getCode() {
        return code;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Date getValidity() {
        return validity;
    }

}
