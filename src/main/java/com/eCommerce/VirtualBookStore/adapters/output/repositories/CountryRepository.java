package com.eCommerce.VirtualBookStore.adapters.output.repositories;

import com.eCommerce.VirtualBookStore.domain.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
