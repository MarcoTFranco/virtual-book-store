package com.eCommerce.VirtualBookStore.adapters.output.repositories;

import com.eCommerce.VirtualBookStore.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
