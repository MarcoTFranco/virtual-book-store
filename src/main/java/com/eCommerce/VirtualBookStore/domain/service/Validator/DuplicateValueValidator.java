package com.eCommerce.VirtualBookStore.domain.service.Validator;

import com.eCommerce.VirtualBookStore.domain.service.annotations.DuplicateValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class DuplicateValueValidator implements ConstraintValidator<DuplicateValue, Object> {
    @PersistenceContext
    private EntityManager manager;

    private String field;

    private Class<?> className;


    @Override
    public void initialize(DuplicateValue constraintAnnotation) {
        field = constraintAnnotation.fieldName();
        className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<?> list = manager.createQuery("select id from " + className.getName() + " where " + field + " =:value")
                .setParameter("value", value).getResultList();
        Assert.isTrue(list.size() <= 1, "Foi encontrado" + className + " com o " + field + "repetido");
        return list.isEmpty();
    }
}
