package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.CouponRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.CouponResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Coupon;
import com.eCommerce.VirtualBookStore.domain.service.coupon.CouponService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping(value = "/coupons")
    public ResponseEntity<CouponResponse> createCoupon (@RequestBody @Valid CouponRequest request) {
        Coupon coupon = couponService.performs(request);
        return ResponseEntity.ok(couponService.toResponse(coupon));
    }
}
