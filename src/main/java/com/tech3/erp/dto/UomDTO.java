package com.tech3.erp.dto;

import com.tech3.erp.entity.Uom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UomDTO {
    private Long id;

    @NotBlank(message = "Uom name is required")
    @Size(min = 1, max = 50, message = "Uom name must be between 3 and 50 characters")
    private String uomName;
    private String uomCode;
    private String description;
    private boolean activeFlag;

    public UomDTO() {}

    public UomDTO(Long id, String uomName, String uomCode, String description, boolean activeFlag) {
        this.id = id;
        this.uomName = uomName;
        this.uomCode = uomCode;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public UomDTO(Uom uom) {
        this.id = uom.getId();
        this.uomName = uom.getUomName();
         this.uomCode = uom.getUomCode();
        this.description = uom.getDescription();
        this.activeFlag = uom.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUomName() { return uomName; }
    public void setUomName(String uomName) { this.uomName = uomName; }

    public String getUomCode() { return uomCode; }
    public void setUomCode(String uomCode) { this.uomCode = uomCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}