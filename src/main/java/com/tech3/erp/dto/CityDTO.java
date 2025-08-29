package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CityDTO {
    private Long id;

    @NotNull
    private Long countryId;
    @JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String countryName;

    @NotNull
    private Long stateId;
    @JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String stateName;

    @NotNull
    @Size(min = 1, max = 100)
    private String cityName;

    private boolean activeFlag;

    public CityDTO() {}

    public CityDTO(Long id, Long countryId, String countryName, Long stateId, String stateName, String cityName, boolean activeFlag) {
        this.id = id;
        this.countryId = countryId;
        this.countryName = countryName;
        this.stateId = stateId;
        this.stateName = stateName;
        this.cityName = cityName;
        this.activeFlag = activeFlag;
    }

    public CityDTO(City city) {
        this.id = city.getId();
        this.countryId = city.getState().getCountry().getId();
        this.countryName = city.getState().getCountry().getCountryName();
        this.stateId = city.getState().getId();
        this.stateName = city.getState().getStateName();
        this.cityName = city.getCityName();
        this.activeFlag = city.getActiveFlag();
    }

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

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
