package com.eCommerce.VirtualBookStore.domain.usecases.book;

public interface FindEntites {

    <T> T find(Class<T> classe, Long id);

}
