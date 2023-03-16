package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.coupon.CouponRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.CouponResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Coupon;
import com.eCommerce.VirtualBookStore.domain.usecases.CouponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    private CouponService service;

    @PostMapping(value = "/coupons")
    public ResponseEntity<?> createCoupon (@RequestBody @Valid CouponRequest request) {
        Coupon coupon = request.toModel();
        service.createCoupon(coupon);
        CouponResponse couponResponse = new CouponResponse(coupon);
        return ResponseEntity.ok(couponResponse);
    }
}
