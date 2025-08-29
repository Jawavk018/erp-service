package com.tech3.erp.dto;

import com.tech3.erp.entity.ShipmentTerms;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ShipmentTermsDTO {
    private Long id;

    @NotBlank(message = "Term name is required")
    @Size(min = 1, max = 50, message = "Term name must be between 3 and 50 characters")
    private String termName;

    private String description;
    private boolean activeFlag;

    public ShipmentTermsDTO() {}

    public ShipmentTermsDTO(Long id, String termName, String description, boolean activeFlag) {
        this.id = id;
        this.termName = termName;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public ShipmentTermsDTO(ShipmentTerms shipmentTerms) {
        this.id = shipmentTerms.getId();
        this.termName = shipmentTerms.getTermName();
        this.description = shipmentTerms.getDescription();
        this.activeFlag = shipmentTerms.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTermName() { return termName; }
    public void setTermName(String termName) { this.termName = termName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}