package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

import java.util.function.Function;

@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String document;
    private String address;
    private String complement;
    private String city;
    private String telephone;
    private String cep;
    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.PERSIST)
    private Order order;

    @Deprecated
    public Payment() {
    }

    public Payment(@Email @NotBlank String email, @NotBlank String name,
                   @NotBlank String surname, @NotBlank String document,
                   @NotBlank String address, @NotBlank String complement,
                   @NotBlank String city, @NotNull Country country,
                   @NotBlank String telephone, @NotBlank String cep,
                   Function<Payment, Order> functionCreateOrder) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.telephone = telephone;
        this.cep = cep;
        this.order = functionCreateOrder.apply(this);
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

    public void setState(@NotNull @Valid State state) {
        Assert.notNull(state, "Não pode associar um estado enquanto o país for nulo");
        Assert.isTrue(state.belongCountry(country), "Este estado não é do país de compra");
        this.state = state;
    }

    public Order getOrder() {
        return order;
    }
}
