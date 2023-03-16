package com.eCommerce.VirtualBookStore.adapters.output.response;

import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponse {
    private String title;
    private AuthorResponse author;
    private String bookSummary;
    private String freeSizeSummary;
    private BigDecimal price;
    private Integer numberOfPages;
    private String isbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;

    public BookResponse(Book book) {
        this.title = book.getTitle();
        this.author = new AuthorResponse(book.getAuthor());
        this.bookSummary = book.getBookSummary();
        this.freeSizeSummary = book.getFreeSizeSummary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.publicationDate = book.getPublicationDate();
    }

    public String getTitle() {
        return title;
    }

    public AuthorResponse getAuthor() {
        return author;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public String getFreeSizeSummary() {
        return freeSizeSummary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
