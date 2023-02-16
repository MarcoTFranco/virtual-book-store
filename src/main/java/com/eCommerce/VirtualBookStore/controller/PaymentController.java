package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entitiesRequest.PaymentRequest;
import com.eCommerce.VirtualBookStore.service.Validator.StateBelongCountryValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private StateBelongCountryValidator stateBelongCountryValidator;

    @PostMapping(value = "/payments")
    public String createPayment (@RequestBody @Valid PaymentRequest request) {
        return request.toString();
    }
}
