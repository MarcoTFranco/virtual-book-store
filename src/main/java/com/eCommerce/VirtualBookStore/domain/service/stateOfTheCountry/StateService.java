package com.eCommerce.VirtualBookStore.domain.service.stateOfTheCountry;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.StateRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.StateResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import com.eCommerce.VirtualBookStore.domain.service.findEntities.FindEntites;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class StateService {

    private StateRepository stateRepository;

    private FindEntites findEntites;

    public StateService(StateRepository stateRepository, FindEntites findEntites) {
        this.stateRepository = stateRepository;
        this.findEntites = findEntites;
    }

    @Transactional
    public State performs(@Valid StateRequestData request) {
        State state = request.toModel(countryId -> findEntites.find(Country.class, countryId));
        stateRepository.save(state);
        return state;
    }

    public StateResponse toResponse(State state) {
        return new StateResponse(state);
    }
}
