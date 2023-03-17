package com.eCommerce.VirtualBookStore.adapters.input.request.book;

import com.eCommerce.VirtualBookStore.domain.entities.Author;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import com.eCommerce.VirtualBookStore.domain.usecases.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.usecases.annotations.ExistId;
import com.eCommerce.VirtualBookStore.domain.usecases.book.BookRequestData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

public class BookRequest implements BookRequestData {
    @NotBlank
    @DuplicateValue(fieldName = "title", className = Book.class)
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
    @DuplicateValue(fieldName = "title", className = Book.class)
    private String isbn;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    @NotNull
    @ExistId(className = Category.class)
    private Long categoryId;
    @NotNull
    @ExistId(className = Author.class)
    private Long authorId;

    public BookRequest(@NotBlank String title, @NotBlank String bookSummary, String freeSizeSummary,
                       @DecimalMin("20.0") BigDecimal price, @Min(100) Integer numberOfPages,
                       @NotBlank String isbn, @Future LocalDate publicationDate,
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
    @Override
    public Book toModel(Function<Long, Author> authorLoads,
                        Function<Long, Category> categoryLoads) {

        @NotNull Category category = categoryLoads.apply(categoryId);
        @NotNull Author author = authorLoads.apply(authorId);

        Assert.state(category != null, "Não pode ser nulo a categoria do livro");
        Assert.state(author != null, "Não pode ser nulo o autor do livro");

        return new Book(title, bookSummary, freeSizeSummary, price,
                numberOfPages, isbn, publicationDate, category, author);
    }
}
