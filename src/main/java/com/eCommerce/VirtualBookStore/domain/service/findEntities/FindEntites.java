package com.eCommerce.VirtualBookStore.domain.service.findEntities;

public interface FindEntites {

    <T> T find(Class<T> classe, Long id);

}
