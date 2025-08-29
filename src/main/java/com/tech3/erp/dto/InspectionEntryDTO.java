package com.tech3.erp.dto;


public class InspectionEntryDTO {
    private Long id;
    private Long fabricInspectionId;
    private Double defectedMeters;
    private Double fromMeters;
    private Double toMeters;
    private Long defectTypeId;
    private Double defectPoints;
    private Long inspectionId;
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

    public Double getDefectedMeters() {
        return defectedMeters;
    }

    public void setDefectedMeters(Double defectedMeters) {
        this.defectedMeters = defectedMeters;
    }

    public Double getFromMeters() {
        return fromMeters;
    }

    public void setFromMeters(Double fromMeters) {
        this.fromMeters = fromMeters;
    }

    public Double getToMeters() {
        return toMeters;
    }

    public void setToMeters(Double toMeters) {
        this.toMeters = toMeters;
    }

    public Long getDefectTypeId() {
        return defectTypeId;
    }

    public void setDefectTypeId(Long defectTypeId) {
        this.defectTypeId = defectTypeId;
    }

    public Double getDefectPoints() {
        return defectPoints;
    }

    public void setDefectPoints(Double defectPoints) {
        this.defectPoints = defectPoints;
    }

    public Long getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

}