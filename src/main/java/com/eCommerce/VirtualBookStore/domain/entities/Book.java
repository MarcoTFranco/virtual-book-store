package com.eCommerce.VirtualBookStore.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 500)
    private String bookSummary;
    private String freeSizeSummary;
    @DecimalMin("20.0")
    private BigDecimal price;
    @Min(100)
    private Integer numberOfPages;
    @NotBlank
    private String isbn;
    @Future
    private LocalDate publicationDate;
    @NotNull
    @ManyToOne
    private Category category;
    @NotNull
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@NotBlank String title, @NotBlank String bookSummary, String freeSizeSummary,
                @DecimalMin("20.0") BigDecimal price, @Min(100) Integer numberOfPages,
                @NotBlank String isbn, @Future LocalDate publicationDate,
                @NotNull @Valid Category category, @NotNull @Valid Author author) {
        this.title = title;
        this.bookSummary = bookSummary;
        this.freeSizeSummary = freeSizeSummary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public String getTitle() {
        return title;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
