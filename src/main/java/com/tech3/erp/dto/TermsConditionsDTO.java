package com.tech3.erp.dto;

import com.tech3.erp.entity.TermsConditions;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TermsConditionsDTO {
    private Long id;

    @NotBlank(message = "Terms & Conditions name is required")
    @Size(min = 1, max = 50, message = "Name must be between 3 and 50 characters")
    private String termsConditionsName;

    private String description;
    private boolean activeFlag;

    public TermsConditionsDTO() {}

    public TermsConditionsDTO(Long id, String termsConditionsName, String description, boolean activeFlag) {
        this.id = id;
        this.termsConditionsName = termsConditionsName;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public TermsConditionsDTO(TermsConditions entity) {
        this.id = entity.getId();
        this.termsConditionsName = entity.getTermsConditionsName();
        this.description = entity.getDescription();
        this.activeFlag = entity.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTermsConditionsName() { return termsConditionsName; }
    public void setTermsConditionsName(String termsConditionsName) { this.termsConditionsName = termsConditionsName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}

