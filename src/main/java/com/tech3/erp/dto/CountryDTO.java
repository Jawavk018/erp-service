package com.tech3.erp.dto;

import com.tech3.erp.entity.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CountryDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String countryName;

    private boolean activeFlag; // Matches active_flag in the database

    // Default constructor
    public CountryDTO() {
    }

    // Constructor with parameters
    public CountryDTO(Long id, String countryName, boolean activeFlag) {
        this.id = id;
        this.countryName = countryName;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public CountryDTO(Country country) {
        this.id = country.getId();
        this.countryName = country.getCountryName();
        this.activeFlag = country.getActiveFlag(); // Assuming a getter in Country entity
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

