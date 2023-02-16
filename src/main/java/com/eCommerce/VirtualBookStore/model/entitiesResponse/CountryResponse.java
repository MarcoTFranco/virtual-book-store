package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Country;

public class CountryResponse {

    private String name;
    public CountryResponse(Country country) {
        this.name = country.getName();
    }

    public String getName() {
        return name;
    }
}
