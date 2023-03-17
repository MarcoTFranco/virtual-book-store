package com.eCommerce.VirtualBookStore.domain.usecases.country;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.CountryRepository;
import com.eCommerce.VirtualBookStore.domain.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public void createCountry(Country country) {
        repository.save(country);
    }
}
