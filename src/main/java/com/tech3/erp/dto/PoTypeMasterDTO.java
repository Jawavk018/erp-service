package com.tech3.erp.dto;

import com.tech3.erp.entity.PoTypeMaster;

public class PoTypeMasterDTO {

    private Long id;
    private String poTypeName;
    private String description;
    private boolean activeFlag;

    public PoTypeMasterDTO() {}

    public PoTypeMasterDTO(PoTypeMaster entity) {
        this.id = entity.getId();
        this.poTypeName = entity.getPoTypeName();
        this.description = entity.getDescription();
        this.activeFlag = entity.getActiveFlag();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoTypeName() {
        return poTypeName;
    }

    public void setPoTypeName(String poTypeName) {
        this.poTypeName = poTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
