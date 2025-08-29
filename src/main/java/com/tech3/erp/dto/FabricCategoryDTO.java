package com.tech3.erp.dto;

import com.tech3.erp.entity.FabricCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FabricCategoryDTO {
    private Long id;

    @NotBlank(message = "Fabric category name is required")
    @Size(min = 1, max = 100, message = "Fabric category name must be between 3 and 100 characters")
    private String fabricCategoryName;

    private boolean activeFlag; // Matches active_flag in the database

    // Default constructor
    public FabricCategoryDTO() {
    }

    // Constructor with parameters
    public FabricCategoryDTO(Long id, String fabricCategoryName, boolean activeFlag) {
        this.id = id;
        this.fabricCategoryName = fabricCategoryName;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public FabricCategoryDTO(FabricCategory fabricCategory) {
        this.id = fabricCategory.getId();
        this.fabricCategoryName = fabricCategory.getFabricCategoryName();
        this.activeFlag = fabricCategory.getActiveFlag();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricCategoryName() {
        return fabricCategoryName;
    }

    public void setFabricCategoryName(String fabricCategoryName) {
        this.fabricCategoryName = fabricCategoryName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
