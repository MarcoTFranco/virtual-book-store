package com.eCommerce.VirtualBookStore.service.annotations;

import com.eCommerce.VirtualBookStore.service.Validator.DuplicateValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = {DuplicateValueValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface DuplicateValue {

    String message() default "{}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> className();

    String fieldName();
}
