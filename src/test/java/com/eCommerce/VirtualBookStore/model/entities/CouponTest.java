package com.eCommerce.VirtualBookStore.model.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

class CouponTest {

    @ParameterizedTest
    @CsvSource({
            "0,true",
            "1,true"
    })
    void test1(long value, boolean result) throws Exception {
        Coupon coupon = new Coupon("codigo", BigDecimal.TEN, LocalDate.now().plusDays(value));
        Assertions.assertEquals(result, coupon.isValid());
    }

    @Test
    @DisplayName("cupom com data passada não eh mais valido")
    void test2() throws Exception {
        Coupon coupon = new Coupon("codigo", BigDecimal.TEN, LocalDate.now().plusDays(1));
        ReflectionTestUtils.setField(coupon, "validity", LocalDate.now().minusDays(1));
        Assertions.assertFalse(coupon.isValid());
    }

    @Test
    @DisplayName("não pode criar cupom com data no passado")
    void test3() throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coupon("codigo", BigDecimal.TEN, LocalDate.now().minusDays(1));
        });
    }

}