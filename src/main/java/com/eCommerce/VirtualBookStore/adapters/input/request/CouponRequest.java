package com.eCommerce.VirtualBookStore.adapters.input.request;

import com.eCommerce.VirtualBookStore.domain.entities.Coupon;
import com.eCommerce.VirtualBookStore.domain.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.service.coupon.CouponRequestData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponRequest implements CouponRequestData {
    @NotBlank
    @DuplicateValue(className = Coupon.class, fieldName = "code")
    private String code;
    @NotNull
    @Positive
    @DecimalMax("100.0")
    private BigDecimal percentage;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validity;

    public CouponRequest(@NotBlank String code, @NotNull BigDecimal percentage, @Future LocalDate validity) {
        this.code = code;
        this.percentage = percentage;
        this.validity = validity;
    }
    @Override
    public Coupon toModel() {
        return new Coupon(code, percentage, validity);
    }
}
