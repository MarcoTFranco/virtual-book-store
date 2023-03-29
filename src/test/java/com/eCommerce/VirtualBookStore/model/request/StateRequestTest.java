package com.eCommerce.VirtualBookStore.model.request;


import com.eCommerce.VirtualBookStore.adapters.input.request.StateRequest;
import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.service.findEntities.FindEntites;
import com.eCommerce.VirtualBookStore.domain.service.stateOfTheCountry.StateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StateRequestTest {

    private final StateRequest request = new StateRequest("", 1L);

    @Test
    @DisplayName("cria o estado se o pais existir no bando de dados")
    void test1() {

        FindEntites service = Mockito.mock(FindEntites.class);

        Mockito.when(service.find(Country.class, 1L)).thenReturn(new Country(""));

        Assertions.assertNotNull(request.toModel(countryId -> service.find(Country.class, countryId)));
    }

    @Test
    @DisplayName("nao cria o estado se o pais existir no bando de dados")
    void test2() {

        FindEntites service = Mockito.mock(FindEntites.class);

        Mockito.when(service.find(Country.class, 1L)).thenReturn(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {
           request.toModel(countryId -> service.find(Country.class, countryId));
        });
    }




}