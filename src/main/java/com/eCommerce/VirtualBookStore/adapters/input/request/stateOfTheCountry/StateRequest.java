package com.eCommerce.VirtualBookStore.adapters.input.request.stateOfTheCountry;

import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import com.eCommerce.VirtualBookStore.domain.usecases.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.usecases.annotations.ExistId;
import com.eCommerce.VirtualBookStore.domain.usecases.stateOfTheCountry.StateService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

public class StateRequest {
    @NotBlank
    @DuplicateValue(fieldName = "name", className = State.class)
    private String name;
    @NotNull
    @ExistId(className = Country.class)
    private Long countryId;

    public StateRequest(@NotBlank String name, @NotNull Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public State toModel(StateService service) {
        @NotNull Country country = service.find(Country.class, countryId);
        Assert.state(country != null, "O estado tem que ter um país");
        return new State(name, country);
    }
}
