package com.eCommerce.VirtualBookStore.repositories;

import com.eCommerce.VirtualBookStore.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
