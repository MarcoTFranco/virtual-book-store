package com.eCommerce.VirtualBookStore.adapters.input.request;

import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.service.country.CountryRequestData;
import jakarta.validation.constraints.NotBlank;

public class CountryRequest implements CountryRequestData {
    @NotBlank
    @DuplicateValue(className = Country.class, fieldName = "name")
    private String name;

    @Deprecated
    public CountryRequest() {
    }

    public CountryRequest(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Country toModel() {
        return new Country(name);
    }
}
