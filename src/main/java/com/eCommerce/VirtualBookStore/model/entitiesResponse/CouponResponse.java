package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CouponResponse {

    private String code;
    private Double percentage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date validity;

    public CouponResponse(Coupon coupon) {
        this.code = coupon.getCode();
        this.percentage = coupon.getPercentage();
        this.validity = coupon.getValidity();
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
