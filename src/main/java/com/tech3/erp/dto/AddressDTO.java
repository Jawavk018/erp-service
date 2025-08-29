package com.tech3.erp.dto;

import com.tech3.erp.entity.Address;

public class AddressDTO {
    private Long id;
    private String line1;
    private String line2;
    private Long countryId;
    private Long stateId;
    private Long cityId;
    private Long pinCode;
    private Boolean activeFlag;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.line1 = address.getLine1();
        this.line2 = address.getLine2();
        this.countryId = address.getCountry() != null ? address.getCountry().getId() : null;
        this.stateId = address.getState() != null ? address.getState().getId() : null;
        this.cityId = address.getCity() != null ? address.getCity().getId() : null;
        this.pinCode = address.getPinCode();
        this.activeFlag = address.getActiveFlag();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    
    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
