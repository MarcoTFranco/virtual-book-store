package com.eCommerce.VirtualBookStore.model.request;

import com.eCommerce.VirtualBookStore.adapters.input.request.OrderItemRequest;
import com.eCommerce.VirtualBookStore.adapters.input.request.OrderRequest;
import com.eCommerce.VirtualBookStore.adapters.input.request.PaymentRequest;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.domain.entities.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

class PaymentRequestTest {

    private final EntityManager manager = Mockito.mock(EntityManager.class);
    private final CouponRepository couponRepository = Mockito.mock(CouponRepository.class);
    private final Set<OrderItemRequest> itens = Set.of(new OrderItemRequest(1L, 5));
    private final OrderRequest order = new OrderRequest(new BigDecimal("250"), itens);
    private final PaymentRequest request = new PaymentRequest("email@gmail.com", "Marco Tulio",
            "Franco", "111.111.111-11", "endereco", "complemento",
            "city", 1L, "000000000", "1455657", order);
    private final Country country = new Country("country");
    private final Author author = new Author("name", "name@gmail.com", "description");
    private final Category category = new Category("category");
    private final Book book = new Book("title", "summary", "summaryFree",
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