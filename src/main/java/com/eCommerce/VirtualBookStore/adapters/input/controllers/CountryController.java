package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.country.CountryRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.CountryResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Country;
import com.eCommerce.VirtualBookStore.domain.usecases.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @PostMapping(value = "/countries")
    public ResponseEntity<?> createCountries(@RequestBody @Valid CountryRequest request) {
        Country country = request.toModel();
        service.createCountry(country);
        CountryResponse countryResponse = new CountryResponse(country);
        return ResponseEntity.ok(countryResponse);
    }

}
