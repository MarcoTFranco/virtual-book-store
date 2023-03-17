package com.eCommerce.VirtualBookStore.domain.usecases.payment;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.PaymentRepository;
import com.eCommerce.VirtualBookStore.domain.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public void createPayment(Payment payment) {
        repository.save(payment);
    }

}
