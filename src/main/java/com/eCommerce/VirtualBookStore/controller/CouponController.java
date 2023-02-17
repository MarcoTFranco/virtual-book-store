package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.CouponRequest;
import com.eCommerce.VirtualBookStore.model.entitiesResponse.CouponResponse;
import com.eCommerce.VirtualBookStore.service.CouponService;
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
