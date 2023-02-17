package com.eCommerce.VirtualBookStore.service;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.eCommerce.VirtualBookStore.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    private CouponRepository repository;

    public void createCoupon (Coupon coupon) {
        repository.save(coupon);
    }

}
