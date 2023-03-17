package com.eCommerce.VirtualBookStore.domain.service.payment;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.domain.entities.Payment;
import jakarta.persistence.EntityManager;

public interface PaymentRequestData {
    Payment toModel(EntityManager manager, CouponRepository couponRepository);
}
