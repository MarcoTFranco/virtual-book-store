package com.eCommerce.VirtualBookStore.domain.usecases.stateOfTheCountry;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.StateRepository;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public void createState(State state) {
        repository.save(state);
    }

    public <T> T find(Class<T> classe, Long id) {
        return manager.find(classe, id);
    }
}
