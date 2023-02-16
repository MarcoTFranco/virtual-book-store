package com.eCommerce.VirtualBookStore.service.Validator;

import com.eCommerce.VirtualBookStore.service.annotations.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Long> {

    @PersistenceContext
    private EntityManager manager;

    private Class<?> className;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        List<?> list = manager.createQuery("select id from " + className.getName() + " where id =:value")
                .setParameter("value", value).getResultList();
        if (value == null || list.size()>0){
            return true;
        }
        return false;
    }
}
