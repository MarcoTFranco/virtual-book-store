package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private BigDecimal percentage;
    @Future
    private LocalDate validity;

    @Deprecated
    public Coupon() {
    }

    public Coupon(@NotBlank String code, @NotNull BigDecimal percentage, @Future LocalDate validity) {
        Assert.isTrue(!validity.isBefore(LocalDate.now()), "A validade precisa ser no futuro");
        this.code = code;
        this.percentage = percentage;
        this.validity = validity;
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

    public boolean isValid() {
        return LocalDate.now().compareTo(this.validity) <= 0;
    }

    public boolean existCoupon(Coupon coupon) {
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
