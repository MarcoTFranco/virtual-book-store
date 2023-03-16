package com.eCommerce.VirtualBookStore.adapters.output.repositories;

import com.eCommerce.VirtualBookStore.domain.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String code);
}
