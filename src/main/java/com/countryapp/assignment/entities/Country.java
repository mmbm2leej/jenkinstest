package com.countryapp.assignment.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="country")
public class Country {

    @Id
    @GeneratedValue
    @Column
    private Long country_id;

    @Column(unique = true, nullable = false)
    @Size(max = 100)
    @NotNull
    @NotBlank
    private String country_name;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private Integer geography_areakm2;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private Double populationmillion;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String capitol;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private Double gdpbillion;

    public Country() {
    }

    public Country(String country_name, Integer geography_areakm2, Double populationmillion, String capitol, Double gdpbillion) {
        this.country_name = country_name;
        this.geography_areakm2 = geography_areakm2;
        this.populationmillion = populationmillion;
        this.capitol = capitol;
        this.gdpbillion = gdpbillion;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Integer getGeography_areakm2() {
        return geography_areakm2;
    }

    public void setGeography_areakm2(Integer geography_areakm2) {
        this.geography_areakm2 = geography_areakm2;
    }

    public Double getPopulationmillion() {
        return populationmillion;
    }

    public void setPopulationmillion(Double populationmillion) {
        this.populationmillion = populationmillion;
    }

    public String getCapitol() {
        return capitol;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public Double getGdpbillion() {
        return gdpbillion;
    }

    public void setGdpbillion(Double gdpbillion) {
        this.gdpbillion = gdpbillion;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_name='" + country_name + '\'' +
                ", geography_areakm2=" + geography_areakm2 +
                ", populationmillion=" + populationmillion +
                ", capitol='" + capitol + '\'' +
                ", gdpbillion=" + gdpbillion +
                '}';
    }
}
