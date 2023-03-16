package com.eCommerce.VirtualBookStore.adapters.output.response;

import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.entities.State;

public class StateResponse {
    private String name;
    private Country country;

    public StateResponse(State state) {
        this.name = state.getName();
        this.country = state.getCountry();
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
