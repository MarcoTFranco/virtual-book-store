package com.eCommerce.VirtualBookStore.repositories;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
