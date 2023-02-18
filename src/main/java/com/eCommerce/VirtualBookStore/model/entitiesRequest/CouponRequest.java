package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.util.Date;

public class CouponRequest {
    @NotBlank
    @DuplicateValue(className = Coupon.class, fieldName = "code")
    private String code;
    @NotNull
    @Positive
    @DecimalMax("100.0")
    private Double percentage;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date validity;

    public CouponRequest(@NotBlank String code, @NotNull Double percentage, @Future Date validity) {
        this.code = code;
        this.percentage = percentage;
        this.validity = validity;
    }


    public Coupon toModel() {
        return new Coupon(code, percentage, validity);
    }
}
