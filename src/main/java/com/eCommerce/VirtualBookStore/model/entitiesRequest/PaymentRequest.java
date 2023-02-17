package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Country;
import com.eCommerce.VirtualBookStore.model.entities.Order;
import com.eCommerce.VirtualBookStore.model.entities.Payment;
import com.eCommerce.VirtualBookStore.model.entities.State;
import com.eCommerce.VirtualBookStore.service.annotations.Document;
import com.eCommerce.VirtualBookStore.service.annotations.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.function.Function;

public class PaymentRequest {
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

    public PaymentRequest(String email, String name, String surname,
                          String document, String address, String complement,
                          String city, Long countryId, Long stateId,
                          String telephone, String cep, OrderRequest orderRequest) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
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

    public Payment toModel(EntityManager manager) {
        @NotNull Country country = manager.find(Country.class, countryId);
        Function<Payment, Order> functionCreateOrder = orderRequest.toModel(manager);
        Payment payment = new Payment(email, name, surname, document, address, complement, city, country, telephone, cep, functionCreateOrder);
        if (stateId != null) {
            payment.setState(manager.find(State.class, stateId));
        }
        return payment;
    }

    public boolean hasBeen() {
        return stateId != null;
    }
}
