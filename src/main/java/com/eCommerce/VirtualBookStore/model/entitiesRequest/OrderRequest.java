package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Order;
import com.eCommerce.VirtualBookStore.model.entities.OrderItem;
import com.eCommerce.VirtualBookStore.model.entities.Payment;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderRequest {
    @Positive
    @NotNull
    private BigDecimal total;
    @Size(min = 1)
    @Valid
    private Set<OrderItemRequest> items = new HashSet<>();


    public OrderRequest(@Positive @NotNull BigDecimal total,
                        @Size(min = 1) @Valid Set<OrderItemRequest> items) {
        this.total = total;
        this.items = items;
    }

    public Function<Payment, Order> toModel(EntityManager manager) {
        Set<OrderItem> caculetedItems = items.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
        return (payment) -> {

            Order order = new Order(payment, caculetedItems);
            Assert.isTrue(order.totalEquals(total), "Total enviado não corresponde ao total real");

            return order;
        };
    }
}
