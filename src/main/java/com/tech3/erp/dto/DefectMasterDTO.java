package com.tech3.erp.dto;

public class DefectMasterDTO {
    private Long id;
    private String defectCode;
    private String defectName;
    private Short defectPoint;
    private String description;
    private Boolean activeFlag = true;

    // Getters
    public Long getId() {
        return id;
    }

    public String getDefectCode() {
        return defectCode;
    }

    public String getDefectName() {
        return defectName;
    }
    
    public Short getDefectPoint() {
    	return defectPoint;
    }
    
    public String getDescription() {
        return description;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    public void setDefectPoint(Short defectPoint) {
    	this.defectPoint = defectPoint;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    // Optional: For boolean fields, you can also use 'is' instead of 'get'
    public Boolean isActiveFlag() {
        return activeFlag;
    }
}