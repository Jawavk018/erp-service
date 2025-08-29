package com.tech3.erp.dto;


public class InspectionDetailDTO {
    private Long id;
    private Long fabricInspectionId;
    private String rollNo;
    private Double doffMeters;
    private Double inspectedMeters;
    private Double weight;
    private Double totalDefectPoints;
    private Double defectCounts;
    private String grade;
    private Boolean activeFlag;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFabricInspectionId() {
        return fabricInspectionId;
    }

    public void setFabricInspectionId(Long fabricInspectionId) {
        this.fabricInspectionId = fabricInspectionId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Double getDoffMeters() {
        return doffMeters;
    }

    public void setDoffMeters(Double doffMeters) {
        this.doffMeters = doffMeters;
    }

    public Double getInspectedMeters() {
        return inspectedMeters;
    }

    public void setInspectedMeters(Double inspectedMeters) {
        this.inspectedMeters = inspectedMeters;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getTotalDefectPoints() {
        return totalDefectPoints;
    }

    public void setTotalDefectPoints(Double totalDefectPoints) {
        this.totalDefectPoints = totalDefectPoints;
    }

    public Double getDefectCounts() {
        return defectCounts;
    }

    public void setDefectCounts(Double defectCounts) {
        this.defectCounts = defectCounts;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    
}
