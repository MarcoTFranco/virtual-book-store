package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponResponse {

    private String code;
    private BigDecimal percentage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate validity;

    public CouponResponse(Coupon coupon) {
        this.code = coupon.getCode();
        this.percentage = coupon.getPercentage();
        this.validity = coupon.getValidity();
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public LocalDate getValidity() {
        return validity;
    }
}
