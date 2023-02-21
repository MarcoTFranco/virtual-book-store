package com.eCommerce.VirtualBookStore.service.Validator;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.PaymentRequest;
import com.eCommerce.VirtualBookStore.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CouponValidator implements Validator {

    @Autowired
    private CouponRepository repository;

    public CouponValidator(CouponRepository couponRepository) {
        super();
        this.repository = couponRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        PaymentRequest request = (PaymentRequest) target;
        Optional<String> possible = Optional.ofNullable(request.getCouponCode());
        if (possible.isPresent()) {
            Coupon coupon = repository.findByCode(possible.get());
            if (!coupon.isValid()) {
                errors.rejectValue("couponCode", null, "Este cupom não é mais válido");
            }
        }
    }
}
