package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponResponse {

    private String couponCode;
    private BigDecimal percentage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate validity;

    public CouponResponse(Coupon coupon) {
        this.couponCode = coupon.getCode();
        this.percentage = coupon.getPercentage();
        this.validity = coupon.getValidity();
    }

    public String getCode() {
        return couponCode;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public LocalDate getValidity() {
        return validity;
    }
}
