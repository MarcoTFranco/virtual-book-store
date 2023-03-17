package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.PaymentRequest;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.PaymentResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Payment;
import com.eCommerce.VirtualBookStore.domain.service.Validator.CouponValidator;
import com.eCommerce.VirtualBookStore.domain.service.Validator.StateBelongCountryValidator;
import com.eCommerce.VirtualBookStore.domain.service.payment.PaymentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private PaymentService service;
    @Autowired
    private CouponValidator couponValidator;
    @Autowired
    private StateBelongCountryValidator stateBelongCountryValidator;

    @PostMapping(value = "/payments")
    public ResponseEntity<?> createPayment(@RequestBody @Valid PaymentRequest request) {
        Payment payment = request.toModel(manager, couponRepository);
        service.createPayment(payment);
        PaymentResponse paymentResponse = new PaymentResponse(payment);
        return ResponseEntity.ok(paymentResponse);
    }
}
