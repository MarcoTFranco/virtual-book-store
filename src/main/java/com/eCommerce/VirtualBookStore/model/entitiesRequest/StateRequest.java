package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Country;
import com.eCommerce.VirtualBookStore.model.entities.State;
import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.service.annotations.ExistId;
import jakarta.persistence.EntityManager;
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

    public State toModel(EntityManager manager) {
        @NotNull Country country = manager.find(Country.class, countryId);
        Assert.state(country != null, "O estado tem que ter um país");
        return new State(name, country);
    }
}
