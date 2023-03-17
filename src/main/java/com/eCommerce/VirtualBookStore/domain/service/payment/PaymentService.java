package com.eCommerce.VirtualBookStore.domain.service.payment;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.PaymentRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.PaymentResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Payment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PaymentService {

    private PaymentRepository paymentRepository;

    private EntityManager manager;

    private CouponRepository couponRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          EntityManager manager,
                          CouponRepository couponRepository) {
        this.paymentRepository = paymentRepository;
        this.manager = manager;
        this.couponRepository = couponRepository;
    }

    @Transactional
    public Payment performs(@Valid PaymentRequestData request) {
        Payment payment = request.toModel(manager, couponRepository);
        paymentRepository.save(payment);
        return payment;
    }

    public PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(payment);
    }
}
