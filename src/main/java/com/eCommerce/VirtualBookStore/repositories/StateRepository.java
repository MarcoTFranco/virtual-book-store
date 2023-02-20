package com.eCommerce.VirtualBookStore.repositories;

import com.eCommerce.VirtualBookStore.model.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
