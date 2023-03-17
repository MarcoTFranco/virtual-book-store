package com.eCommerce.VirtualBookStore.domain.service.stateOfTheCountry;

import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.entities.State;

import java.util.function.Function;

public interface StateRequestData {

    State toModel(Function<Long, Country> countryLoads);

}
