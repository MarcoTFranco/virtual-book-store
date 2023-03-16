package com.eCommerce.VirtualBookStore.adapters.output.repositories;

import com.eCommerce.VirtualBookStore.domain.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
