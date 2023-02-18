package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Payment;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.PaymentRequest;
import com.eCommerce.VirtualBookStore.model.entitiesResponse.PaymentResponse;
import com.eCommerce.VirtualBookStore.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.service.PaymentService;
import com.eCommerce.VirtualBookStore.service.Validator.CouponValidator;
import com.eCommerce.VirtualBookStore.service.Validator.StateBelongCountryValidator;
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
