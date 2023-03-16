package com.eCommerce.VirtualBookStore.domain.usecases.Validator;

import com.eCommerce.VirtualBookStore.domain.usecases.annotations.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {

    @PersistenceContext
    private EntityManager manager;

    private Class<?> className;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        List<?> list = manager.createQuery("select id from " + className.getName() + " where id =:value")
                .setParameter("value", value).getResultList();
        if (value == null || list.size()>0){
            return true;
        }
        return false;
    }
}
