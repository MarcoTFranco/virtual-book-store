package com.eCommerce.VirtualBookStore.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String bookSummary;
    private String freeSizeSummary;
    private Double price;
    private Integer numberOfPages;
    private String isbn;
    private Date publicationDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@NotBlank String title, @NotBlank String bookSummary, String freeSizeSummary,
                @DecimalMin("20.0") Double price, @Min(100) Integer numberOfPages,
                @NotBlank String isbn, @Future Date publicationDate,
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

    public Double getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
