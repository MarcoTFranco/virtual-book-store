package com.eCommerce.VirtualBookStore.domain.service.coupon;

import com.eCommerce.VirtualBookStore.adapters.input.request.CouponRequest;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.CouponResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Coupon;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CouponService {

    private CouponRepository repository;

    public CouponService(CouponRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Coupon performs(@Valid CouponRequest request) {
        Coupon coupon = request.toModel();
        repository.save(coupon);
        return coupon;
    }

    public CouponResponse toResponse(Coupon coupon) {
        return new CouponResponse(coupon);
    }
}
