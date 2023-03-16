package com.eCommerce.VirtualBookStore.domain.usecases.Validator;

import com.eCommerce.VirtualBookStore.adapters.input.request.payment.PaymentRequest;
import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StateBelongCountryValidator implements Validator {
    @PersistenceContext
    private EntityManager manager;

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

        if(request.hasBeen()) {
            Country country = manager.find(Country.class, request.getCountryId());
            State state = manager.find(State.class, request.getStateId());
            if (!state.belongCountry(country)) {
                errors.rejectValue("stateId", null, "Este estado não pertence ao país");
            }
        }
    }
}
