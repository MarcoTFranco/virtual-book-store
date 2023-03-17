package com.eCommerce.VirtualBookStore.domain.service.country;

import com.eCommerce.VirtualBookStore.adapters.input.request.CountryRequest;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.CountryRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.CountryResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Country;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public Country performs(@Valid CountryRequest request) {
        Country country = request.toModel();
        countryRepository.save(country);
        return country;
    }

    public CountryResponse toResponse(Country country) {
        return new CountryResponse(country);
    }
}
