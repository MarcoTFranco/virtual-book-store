package com.eCommerce.VirtualBookStore.adapters.output.repositories;

import com.eCommerce.VirtualBookStore.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
