package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.PaymentRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.PaymentResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Payment;
import com.eCommerce.VirtualBookStore.domain.service.Validator.CouponValidator;
import com.eCommerce.VirtualBookStore.domain.service.Validator.StateBelongCountryValidator;
import com.eCommerce.VirtualBookStore.domain.service.payment.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    private CouponValidator couponValidator;

    private StateBelongCountryValidator stateBelongCountryValidator;


    public PaymentController(PaymentService paymentService,
                             CouponValidator couponValidator,
                             StateBelongCountryValidator stateBelongCountryValidator) {
        this.paymentService = paymentService;
        this.couponValidator = couponValidator;
        this.stateBelongCountryValidator = stateBelongCountryValidator;
    }

    @PostMapping(value = "/payments")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody @Valid PaymentRequest request) {
        Payment payment = paymentService.performs(request);
        return ResponseEntity.ok(paymentService.toResponse(payment));
    }
}
