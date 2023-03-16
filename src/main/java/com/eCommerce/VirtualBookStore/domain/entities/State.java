package com.eCommerce.VirtualBookStore.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @ManyToOne
    private Country country;

    @Deprecated
    public State() {
    }

    public State( @NotBlank String name, @NotNull Country country) {
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

