package com.eCommerce.VirtualBookStore.domain.usecases;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.domain.entities.Coupon;
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
