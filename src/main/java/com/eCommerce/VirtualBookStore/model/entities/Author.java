package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_name")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @Size(max = 400)
    private String description;
    @NotNull
    private LocalDate moment = LocalDate.now();
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @Deprecated
    public Author() {
    }

    public Author(@NotBlank String name, @NotBlank @Email String email,
                  @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public List<Book> getBooks() {
        return books;
    }
}
