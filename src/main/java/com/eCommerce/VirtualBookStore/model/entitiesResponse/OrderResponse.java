package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Order;
import com.eCommerce.VirtualBookStore.model.entities.OrderItem;
import com.eCommerce.VirtualBookStore.model.entities.Payment;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.aspectj.weaver.ast.Or;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderResponse {

    private Set<OrderItemResponse> items = new HashSet<>();

    public OrderResponse(Order order) {
        this.items = order.getItems().stream().map(OrderItemResponse::new).collect(Collectors.toSet());
    }

    public Set<OrderItemResponse> getItems() {
        return items;
    }
}
