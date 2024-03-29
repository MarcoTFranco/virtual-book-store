package com.eCommerce.VirtualBookStore.adapters.input.request;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.CouponRepository;
import com.eCommerce.VirtualBookStore.domain.entities.*;
import com.eCommerce.VirtualBookStore.domain.service.annotations.Document;
import com.eCommerce.VirtualBookStore.domain.service.annotations.ExistId;
import com.eCommerce.VirtualBookStore.domain.service.payment.PaymentRequestData;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.function.Function;

public class PaymentRequest implements PaymentRequestData {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Document
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @NotNull
    @ExistId(className = Country.class)
    private Long countryId;
    @ExistId(className = State.class)
    private Long stateId;
    @NotBlank
    private String telephone;
    @NotBlank
    private String cep;
    @Valid
    @NotNull
    private OrderRequest orderRequest;
    private String couponCode;

    public PaymentRequest(@NotBlank @Email String email, @NotBlank String name, @NotBlank String surname,
                          @NotBlank @Document String document, @NotBlank String address, @NotBlank String complement,
                          @NotBlank String city, @NotNull Long countryId,
                          @NotBlank String telephone, @NotBlank String cep, @NotNull @Valid OrderRequest orderRequest) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.telephone = telephone;
        this.cep = cep;
        this.orderRequest = orderRequest;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getDocument() {
        return document;
    }

    @Override
    public Payment toModel(EntityManager manager, CouponRepository couponRepository) {
        @NotNull Country country = manager.find(Country.class, countryId);

        Function<Payment, Order> functionCreateOrder = orderRequest.toModel(manager);

        Payment payment = new Payment(email, name, surname, document, address,
                complement, city, country, telephone, cep, functionCreateOrder);
        if (stateId != null) {
            payment.setState(manager.find(State.class, stateId));
        }

        if (StringUtils.hasText(couponCode)) {
            Coupon coupon = couponRepository.findByCode(couponCode);
            payment.applyCoupon(coupon);
        }
        return payment;
    }

    public boolean hasBeen() {
        return Optional.ofNullable(stateId).isPresent();
    }

    public Optional<String> hasCouponDiscount() {
        return Optional.ofNullable(couponCode);
    }
}
