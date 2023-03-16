package com.eCommerce.VirtualBookStore.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    @Deprecated
    public Category() {
    }

    public Category(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
