package com.eCommerce.VirtualBookStore.service.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.lang.annotation.*;
@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Constraint(validatedBy = { })
@Documented

public @interface Document {
    String message() default "{com.eCommerce.VirtualBookStore.model.entitiesRequest.PaymentRequest}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


