package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    @NotNull
    private BigDecimal total;

    private BigDecimal totalWithDiscount;

    @OneToOne
    private Payment payment;
    @Size(min = 1)
    @Valid
    @ElementCollection
    private Set<OrderItem> items = new HashSet<>();

    @Deprecated
    public Order() {
    }

    public Order(@NotNull @Valid Payment payment,
                 @Size(min = 1) Set<OrderItem> items) {
        Assert.isTrue(!items.isEmpty(), "Não pode esta vazio!");
        this.payment = payment;
        this.items.addAll(items);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public Payment getPayment() {
        return payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setTotalWithDiscount(BigDecimal totalWithDiscount) {
        this.totalWithDiscount = totalWithDiscount;
    }

    public boolean totalEquals(@Positive @NotNull BigDecimal total) {
        BigDecimal totalOrder = items.stream().map(OrderItem::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        setTotal(totalOrder);
        return totalOrder.doubleValue() == total.doubleValue();
    }

    public void applyDiscount(Coupon coupon, BigDecimal total) {
        if (totalEquals(total)) {
            if (coupon.isValid()) {
                BigDecimal percentageDiscount = coupon.getPercentage();
                this.totalWithDiscount = total.subtract((total.multiply(percentageDiscount))
                        .divide(BigDecimal.valueOf(100.0)));
            }
        }
    }
}
