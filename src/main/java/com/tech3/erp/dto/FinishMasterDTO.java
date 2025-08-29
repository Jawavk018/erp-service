package com.tech3.erp.dto;


import com.tech3.erp.entity.FinishMaster;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FinishMasterDTO {
    private Long id;

    @NotBlank(message = "Finish Name is required")
    @Size(min = 1, max = 50, message = "Finish Name must be between 3 and 50 characters")
    private String finishName;
    private String finishCode;
    private String description;
    private boolean activeFlag;

    public FinishMasterDTO() {}

    public FinishMasterDTO(Long id, String finishName, String finishCode, String description, boolean activeFlag) {
        this.id = id;
        this.finishName = finishName;
        this.finishCode = finishCode;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public FinishMasterDTO(FinishMaster finishMaster) {
        this.id = finishMaster.getId();
        this.finishName = finishMaster.getFinishName();
         this.finishCode = finishMaster.getFinishCode();
        this.description = finishMaster.getDescription();
        this.activeFlag = finishMaster.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFinishName() { return finishName; }
    public void setFinishName(String finishName) { this.finishName = finishName; }

    public String getFinishCode() { return finishCode; }
    public void setFinishCode(String finishCode) { this.finishCode = finishCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}