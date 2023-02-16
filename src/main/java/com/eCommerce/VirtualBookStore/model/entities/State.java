package com.eCommerce.VirtualBookStore.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Country country;

    @Deprecated
    public State() {
    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public boolean belongCountry(Country country) {
        return this.country.equals(country) && this.country.hashCode() == country.hashCode();
    }
}

