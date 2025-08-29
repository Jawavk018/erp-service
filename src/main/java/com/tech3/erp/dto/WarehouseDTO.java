package com.tech3.erp.dto;


import com.tech3.erp.entity.Warehouse;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WarehouseDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String warehouseName;

    private boolean activeFlag; // Matches active_flag in the database

    // Default constructor
    public WarehouseDTO() {
    }

    // Constructor with parameters
    public WarehouseDTO(Long id, String warehouseName, boolean activeFlag) {
        this.id = id;
        this.warehouseName = warehouseName;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public WarehouseDTO(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.warehouseName = warehouse.getWarehouseName();
        this.activeFlag = warehouse.getActiveFlag(); // Assuming a getter in Country entity
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}

