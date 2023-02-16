package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Country;
import com.eCommerce.VirtualBookStore.model.entities.State;
import com.eCommerce.VirtualBookStore.service.annotations.Document;
import com.eCommerce.VirtualBookStore.service.annotations.ExistId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

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

    public PaymentRequest(String email, String name, String surname,
                          String document, String address, String complement,
                          String city, Long countryId, Long stateId,
                          String telephone, String cep) {
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
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                ", telephone='" + telephone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
