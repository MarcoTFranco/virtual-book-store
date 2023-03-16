package com.eCommerce.VirtualBookStore.adapters.output.response;

import com.eCommerce.VirtualBookStore.domain.entities.Country;

public class CountryResponse {

    private String name;

    public CountryResponse(Country country) {
        this.name = country.getName();
    }

    public String getName() {
        return name;
    }
}
