package com.tech3.erp.dto;

import com.tech3.erp.entity.Flange;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FlangeDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String flangeNo;

    private boolean activeFlag; // Matches active_flag in the database

    // Default constructor
    public FlangeDTO() {
    }

    // Constructor with parameters
    public FlangeDTO(Long id, String flangeNo, boolean activeFlag) {
        this.id = id;
        this.flangeNo = flangeNo;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public FlangeDTO(Flange flange) {
        this.id = flange.getId();
        this.flangeNo = flange.getFlangeNo();
        this.activeFlag = flange.getActiveFlag(); // Assuming a getter in Country entity
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlangeNo() {
        return flangeNo;
    }

    public void setFlangeNo(String flangeNo) {
        this.flangeNo = flangeNo;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}

