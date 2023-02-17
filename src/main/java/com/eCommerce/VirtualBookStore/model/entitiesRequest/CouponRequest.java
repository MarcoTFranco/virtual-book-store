package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Date;

public class CouponRequest {
    @NotBlank
    @DuplicateValue(className = Coupon.class, fieldName = "code")
    private String code;
    @NotNull
    @Positive
    private Double percentage;
    @Future
    private Date validity;

    public CouponRequest(String code, Double percentage, Date validity) {
        this.code = code;
        this.percentage = percentage;
        this.validity = validity;
    }


    public Coupon toModel() {
        return new Coupon(code, percentage, validity);
    }
}
