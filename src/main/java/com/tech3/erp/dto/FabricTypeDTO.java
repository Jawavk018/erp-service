package com.tech3.erp.dto;

import com.tech3.erp.entity.FabricType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FabricTypeDTO {
    private Long id;

    @NotBlank(message = "Fabric type name is required")
    @Size(min = 1, max = 100, message = "Fabric type name must be between 3 and 100 characters")
    private String fabricTypeName;

    private boolean activeFlag; // Matches active_flag in the database

    // Default constructor
    public FabricTypeDTO() {
    }

    // Constructor with parameters
    public FabricTypeDTO(Long id, String fabricTypeName, boolean activeFlag) {
        this.id = id;
        this.fabricTypeName = fabricTypeName;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public FabricTypeDTO(FabricType fabricType) {
        this.id = fabricType.getId();
        this.fabricTypeName = fabricType.getFabricTypeName();
        this.activeFlag = fabricType.getActiveFlag();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricTypeName() {
        return fabricTypeName;
    }

    public void setFabricTypeName(String fabricTypeName) {
        this.fabricTypeName = fabricTypeName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
