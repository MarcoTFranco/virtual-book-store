package com.eCommerce.VirtualBookStore.domain.service.book;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.BookRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.BookResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Author;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import com.eCommerce.VirtualBookStore.domain.service.findEntities.FindEntites;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class BookService {

    private BookRepository bookRepository;

    private FindEntites findEntites;

    public BookService(BookRepository bookRepository, FindEntites findEntites) {
        this.bookRepository = bookRepository;
        this.findEntites = findEntites;
    }

    public  List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book performs(@Valid BookRequestData request) {
        Book book = request.toModel(
                authorId -> findEntites.find(Author.class, authorId),
                categoryId -> findEntites.find(Category.class, categoryId));
        bookRepository.save(book);
        return book;
    }

    public BookResponse toResponse(Book book) {
        return new BookResponse(book);
    }

    public List<BookResponse> toListResponse(List<Book> books) {
        return books.stream()
                .map(BookResponse::new)
                .toList();
    }
}
