package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Country;
import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import jakarta.validation.constraints.NotBlank;

public class CountryRequest {
    @NotBlank
    @DuplicateValue(className = Country.class, fieldName = "name")
    private String name;

    @Deprecated
    public CountryRequest() {
    }

    public CountryRequest (@NotBlank String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country toModel() {
        return new Country(name);
    }
}
