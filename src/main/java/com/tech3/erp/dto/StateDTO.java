package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.State;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StateDTO {
    private Long id;

    @NotNull
    private Long countryId;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String countryName;

    @NotNull
    @Size(min = 1, max = 100)
    private String stateName;

    private boolean activeFlag;

    // Default Constructor
    public StateDTO() {}

    // Constructor with parameters
    public StateDTO(Long id, Long countryId, String countryName, String stateName, boolean activeFlag) {
        this.id = id;
        this.countryId = countryId;
        this.countryName = countryName;
        this.stateName = stateName;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public StateDTO(State state) {
        this.id = state.getId();
        this.countryId = state.getCountry().getId();
        this.countryName = state.getCountry().getCountryName(); // Fetch country name
        this.stateName = state.getStateName();
        this.activeFlag = state.getActiveFlag();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
