package com.eCommerce.VirtualBookStore.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CouponApplied {

    @JsonIgnore
    @ManyToOne
    private Coupon coupon;
    @Positive
    @NotNull
    private BigDecimal percentualdiscount;
    @NotNull
    @Future
    private LocalDate validity;

    @Deprecated
    public CouponApplied() {
    }

    public CouponApplied(Coupon coupon) {
        this.coupon = coupon;
        this.percentualdiscount = coupon.getPercentage();
        this.validity = coupon.getValidity();
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public BigDecimal getPercentualdiscount() {
        return percentualdiscount;
    }

    public LocalDate getValidity() {
        return validity;
    }
}
