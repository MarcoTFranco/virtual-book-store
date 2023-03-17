package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.StateRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.StateResponse;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import com.eCommerce.VirtualBookStore.domain.service.stateOfTheCountry.StateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @PostMapping(value = "/states")
    public ResponseEntity<StateResponse> createState(@RequestBody @Valid StateRequest request) {
        State state = stateService.performs(request);
        return ResponseEntity.ok(stateService.toResponse(state));
    }

}
