package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.*;
import com.eCommerce.VirtualBookStore.repositories.CouponRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

class PaymentRequestTest {

    private EntityManager manager = Mockito.mock(EntityManager.class);
    private CouponRepository couponRepository = Mockito.mock(CouponRepository.class);
    private Set<OrderItemRequest> itens = Set.of(new OrderItemRequest(1L, 5));
    private OrderRequest order = new OrderRequest(new BigDecimal("250"), itens);
    private PaymentRequest request = new PaymentRequest("email@gmail.com", "Marco Tulio",
            "Franco", "111.111.111-11", "endereco", "complemento",
            "Belo Horizonte", 1L, "000000000", "1455657", order);
    private Country country = new Country("country");
    private Author author = new Author("name", "name@gmail.com", "description");
    private Category category = new Category("category");
    private Book book = new Book("title", "summary", "summaryFree",
            BigDecimal.valueOf(Long.parseLong("50")), 100,
            "1233456789", LocalDate.of(2000, 1, 1), category, author);

    {
        Mockito.when(manager.find(Country.class, 1L)).thenReturn(country);
        Mockito.when(manager.find(Book.class, 1L)).thenReturn(book);
        Mockito.when(manager.find(State.class, 1L)).thenReturn(new State("state", country));
        Mockito.when(couponRepository.findByCode("code-coupon"))
                .thenReturn(new Coupon("code-coupon", BigDecimal.TEN, LocalDate.now().plusDays(1)));
    }

    @Test
    @DisplayName("cria compra com estado e cupom")
    void test1() throws Exception {

        request.setCouponCode("code-coupon");
        request.setStateId(1L);
        Payment payment = request.toModel(manager, couponRepository);

        Assertions.assertNotNull(payment);
        Mockito.verify(manager).find(State.class, 1L);
        Mockito.verify(couponRepository).findByCode("code-coupon");

    }

    @Test
    @DisplayName("cria compra sem estado e cupom")
    void test2() throws Exception {

        request.setCouponCode("code-coupon");
        Payment payment = request.toModel(manager, couponRepository);

        Assertions.assertNotNull(payment);
        Mockito.verify(manager, Mockito.never()).find(Mockito.eq(State.class), Mockito.anyLong());
        Mockito.verify(couponRepository).findByCode("code-coupon");

    }

    @Test
    @DisplayName("cria sem estado e sem cupom")
    void test3() throws Exception {

        Payment payment = request.toModel(manager, couponRepository);

        Assertions.assertNotNull(payment);
        Mockito.verify(manager, Mockito.never()).find(Mockito.eq(State.class), Mockito.anyLong());
        Mockito.verify(couponRepository, Mockito.never()).findByCode(Mockito.anyString());

    }
}