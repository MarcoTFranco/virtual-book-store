package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String code;
    @NotNull
    @Positive
    @DecimalMax("100.0")
    private Double percentage;
    @Future
    private Date validity;

    @Deprecated
    public Coupon() {
    }

    public Coupon(@NotBlank String code, @NotNull Double percentage, @Future Date validity) {
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

    public boolean isValid() {
        return Instant.now().compareTo(this.validity.toInstant()) <= 0;
    }

    public boolean existCoupon(Coupon coupon){
        return this.code.equals(coupon.getCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(code, coupon.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
