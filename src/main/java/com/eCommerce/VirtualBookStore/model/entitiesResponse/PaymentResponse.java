package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Country;
import com.eCommerce.VirtualBookStore.model.entities.Payment;
import com.eCommerce.VirtualBookStore.model.entities.State;

public class PaymentResponse {

    private String email;
    private String name;
    private String surname;
    private String document;
    private String address;
    private String complement;
    private String city;
    private String telephone;
    private String cep;
    private Country country;
    private State state;

    private OrderResponse order;

    public PaymentResponse(Payment payment) {
        this.email = payment.getEmail();
        this.name = payment.getName();
        this.surname = payment.getSurname();
        this.document = payment.getDocument();
        this.address = payment.getAddress();
        this.complement = payment.getComplement();
        this.city = payment.getCity();
        this.country = payment.getCountry();
        this.state = payment.getState();
        this.telephone = payment.getTelephone();
        this.cep = payment.getCep();
        this.order = new OrderResponse(payment.getOrder());
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCep() {
        return cep;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public OrderResponse getOrder() {
        return order;
    }
}
