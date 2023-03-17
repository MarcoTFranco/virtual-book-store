package com.eCommerce.VirtualBookStore.adapters.input.request;

import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.entities.State;
import com.eCommerce.VirtualBookStore.domain.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.service.annotations.ExistId;
import com.eCommerce.VirtualBookStore.domain.service.stateOfTheCountry.StateRequestData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

import java.util.function.Function;

public class StateRequest implements StateRequestData {
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

    public State toModel(Function<Long, Country> countryLoads) {
        @NotNull Country country = countryLoads.apply(countryId);
        Assert.state(country != null, "O estado tem que ter um país");
        return new State(name, country);
    }
}
