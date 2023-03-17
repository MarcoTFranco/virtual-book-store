package com.eCommerce.VirtualBookStore.domain.service.annotations;

import com.eCommerce.VirtualBookStore.domain.service.Validator.ExistIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = {ExistIdValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistId {

    String message() default "O id não existe";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> className();
}
