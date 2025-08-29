package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "country", schema = "masters")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name", unique = true, nullable = false, length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private String countryName;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;  // Default value as per the DB schema

    // Default constructor
    public Country() {
    }

    // Constructor with parameters
    public Country(Long id, String countryName, boolean activeFlag) {
        this.id = id;
        this.countryName = countryName;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}


