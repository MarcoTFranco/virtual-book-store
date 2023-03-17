package com.eCommerce.VirtualBookStore.domain.usecases.book;

import com.eCommerce.VirtualBookStore.domain.entities.Author;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.entities.Category;

import java.util.function.Function;

public interface BookRequestData {

    Book toModel(Function<Long, Author> authorLoads,
                 Function<Long, Category> categoryLoads);

}
