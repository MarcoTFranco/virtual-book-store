package com.eCommerce.VirtualBookStore.service.Validator;

import com.eCommerce.VirtualBookStore.model.entities.Coupon;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.OrderItemRequest;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.OrderRequest;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.PaymentRequest;
import com.eCommerce.VirtualBookStore.repositories.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

class CouponValidatorTest {

    private CouponRepository couponRepository = Mockito.mock(CouponRepository.class);
    private Set<OrderItemRequest> itens = Set.of(new OrderItemRequest(1L, 10));
    private OrderRequest orderRequest = new OrderRequest(BigDecimal.TEN, itens);
    private PaymentRequest request = new PaymentRequest("email@gmail.com", "Marco Tulio",
            "Franco", "111.111.111-11", "endereco", "complemento",
            "city", 1L, "000000000", "1455657", orderRequest);

    @Test
    @DisplayName("deveria parar caso o cupom esteja invalido")
    void test1() throws Exception {
        Coupon coupon = new Coupon("code", BigDecimal.TEN, LocalDate.now().plusDays(1));
        ReflectionTestUtils.setField(coupon, "validity", LocalDate.now().minusDays(1));

        request.setCouponCode("code");
        Mockito.when(couponRepository.findByCode("code")).thenReturn(coupon);

        Errors errors = new BeanPropertyBindingResult(request, "target");
        CouponValidator validator = new CouponValidator(couponRepository);
        validator.validate(request, errors);

        Assertions.assertTrue(errors.getAllErrors().size() == 1);
        Assertions.assertEquals(errors.hasErrors(), errors.hasFieldErrors("couponCode"));
    }

    @Test
    @DisplayName("deveria passar caso o cupom esteja válido")
    void test2() throws Exception {
        Coupon coupon = new Coupon("code", BigDecimal.TEN, LocalDate.now().plusDays(1));

        request.setCouponCode("code");
        Mockito.when(couponRepository.findByCode("code")).thenReturn(coupon);

        Errors errors = new BeanPropertyBindingResult(request, "target");
        CouponValidator validator = new CouponValidator(couponRepository);
        validator.validate(request, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

    @Test
    @DisplayName("deveria passar caso nao tenha codigo de cupom")
    void test3() throws Exception {
        Errors errors = new BeanPropertyBindingResult(request, "target");
        CouponValidator validator = new CouponValidator(couponRepository);
        validator.validate(request, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

    @Test
    @DisplayName("deveria parar caso já tenha erro")
    void test4() throws Exception {
        Errors errors = new BeanPropertyBindingResult(request, "target");
        errors.reject("code");

        CouponValidator validator = new CouponValidator(couponRepository);
        validator.validate(request, errors);

        Assertions.assertTrue(errors.getAllErrors().size() == 1);
        Assertions.assertEquals("code", errors.getGlobalErrors().get(0).getCode());
    }

}