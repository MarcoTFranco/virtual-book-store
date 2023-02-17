package com.eCommerce.VirtualBookStore.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne
    private Payment payment;
    @ElementCollection
    private Set<OrderItem> items = new HashSet<>();

    @Deprecated
    public Order(){
    }

    public Order(@NotNull @Valid Payment payment, @Size(min = 1) Set<OrderItem> items) {
        Assert.isTrue(!items.isEmpty(), "Não pode esta vazio!");
        this.payment = payment;
        this.items.addAll(items);
    }

    public Payment getPayment() {
        return payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public boolean totalEquals(@Positive @NotNull BigDecimal total) {
        BigDecimal totalOrder = items.stream().map(OrderItem::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalOrder.doubleValue() == total.doubleValue();
    }
}
