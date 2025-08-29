package com.tech3.erp.dto;

public class GradeMasterDTO {
    private Long id;
    private String gradeCode;
    private String gradeName;
    private Short minPoint;
    private Short maxPoint;
    private String description;
    private Boolean activeFlag = true;

    // Getters
    public Long getId() {
        return id;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public String getGradeName() {
        return gradeName;
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

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
    
    public Short getMinPoint() {
    	return minPoint;
    }
    
    public void setMinPoint(Short minPoint) {
    	this.minPoint = minPoint;
    }

    public Short getMaxPoint() {
    	return maxPoint;
    }
    
    public void setMaxPoint(Short maxPoint) {
    	this.maxPoint = maxPoint;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}