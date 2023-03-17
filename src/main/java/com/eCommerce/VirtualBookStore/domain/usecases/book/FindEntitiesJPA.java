package com.eCommerce.VirtualBookStore.domain.usecases.book;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindEntitiesJPA implements FindEntites {

    @Autowired
    private EntityManager entityManager;

    @Override
    public <T> T find(Class<T> classe, Long id) {
        return entityManager.find(classe, id);
    }
}
