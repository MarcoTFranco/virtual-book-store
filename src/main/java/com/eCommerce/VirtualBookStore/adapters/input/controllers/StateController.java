package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.stateOfTheCountry.StateRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.StateResponse;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import com.eCommerce.VirtualBookStore.domain.usecases.stateOfTheCountry.StateService;
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


    @PostMapping(value = "/states")
    public ResponseEntity<StateResponse> createState(@RequestBody @Valid StateRequest request) {
        State state = request.toModel(service);
        service.createState(state);
        StateResponse stateResponse = new StateResponse(state);
        return ResponseEntity.ok(stateResponse);
    }

}
