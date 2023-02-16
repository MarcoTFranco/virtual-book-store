package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Country;
import com.eCommerce.VirtualBookStore.model.entities.State;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.StateRequest;
import com.eCommerce.VirtualBookStore.model.entitiesResponse.StateResponse;
import com.eCommerce.VirtualBookStore.service.StateService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    @Autowired
    private StateService service;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/states")
    public ResponseEntity<StateResponse> createState (@RequestBody @Valid StateRequest request) {
        State state = request.toModel(manager);
        service.createState(state);
        StateResponse stateResponse = new StateResponse(state);
        return ResponseEntity.ok(stateResponse);
    }

}
