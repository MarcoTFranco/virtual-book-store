package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Author;
import com.eCommerce.VirtualBookStore.model.entities.Book;
import com.eCommerce.VirtualBookStore.model.entities.Category;
import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.service.annotations.ExistId;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.util.Date;

public class BookRequest {
    @NotBlank
    @DuplicateValue(fieldName = "title", className = Book.class)
    private String title;
    @NotBlank
    @Size(max = 500)
    private String bookSummary;
    private String freeSizeSummary;
    @DecimalMin("20.0")
    private Double price;
    @Min(100)
    private Integer numberOfPages;
    @NotBlank
    @DuplicateValue(fieldName = "title", className = Book.class)
    private String isbn;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publicationDate;
    @NotNull
    @ExistId(className = Category.class)
    private Long categoryId;
    @NotNull
    @ExistId(className = Author.class)
    private Long authorId;

    public BookRequest(@NotBlank String title, @NotBlank String bookSummary, String freeSizeSummary,
                       @DecimalMin("20.0") Double price, @Min(100) Integer numberOfPages,
                       @NotBlank String isbn, @Future Date publicationDate,
                       @NotNull Long categoryId, @NotNull Long authorId) {
        this.title = title;
        this.bookSummary = bookSummary;
        this.freeSizeSummary = freeSizeSummary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book toModel(EntityManager manager) {

        @NotNull Category category = manager.find(Category.class, categoryId);
        @NotNull Author author = manager.find(Author.class, authorId);

        Assert.state(category != null, "Não pode ser nulo a categoria do livro");
        Assert.state(author != null, "Não pode ser nulo o autor do livro");

        return new Book(title, bookSummary, freeSizeSummary, price,
                numberOfPages, isbn, publicationDate, category, author);
    }
}
