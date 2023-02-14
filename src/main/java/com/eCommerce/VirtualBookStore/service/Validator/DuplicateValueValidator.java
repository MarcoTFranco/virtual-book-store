package com.eCommerce.VirtualBookStore.service.Validator;

import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class DuplicateValueValidator implements ConstraintValidator<DuplicateValue, Object> {

    private String field;

    private Class<?> className;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(DuplicateValue constraintAnnotation) {
        field = constraintAnnotation.fieldName();
        className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query =
                manager.createQuery("select id from " + className.getName() + " where " + field + " =:value")
                        .setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <= 1,
                "Foi encontrado"+ className + " com o "+ field + "repetido");
        return list.isEmpty();
    }
}
