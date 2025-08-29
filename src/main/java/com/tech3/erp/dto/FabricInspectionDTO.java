package com.tech3.erp.dto;

import java.time.LocalDate;
import java.util.List;

public class FabricInspectionDTO {
    private Long id;
    private LocalDate inspectionDate;
    private Double loomNo;
    private Long vendorId;
    private String fabricQuality;
    private Double doffMeters;
    private Long doffWeight;
    private Boolean activeFlag;
    private List<InspectionDetailDTO> inspectionDetails;
    private List<InspectionEntryDTO> inspectionEntries;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Double getLoomNo() {
        return loomNo;
    }

    public void setLoomNo(Double loomNo) {
        this.loomNo = loomNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getFabricQuality() {
        return fabricQuality;
    }

    public void setFabricQuality(String fabricQuality) {
        this.fabricQuality = fabricQuality;
    }

    public Double getDoffMeters() {
        return doffMeters;
    }

    public void setDoffMeters(Double doffMeters) {
        this.doffMeters = doffMeters;
    }

    public Long getDoffWeight() {
        return doffWeight;
    }

    public void setDoffWeight(Long doffWeight) {
        this.doffWeight = doffWeight;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<InspectionDetailDTO> getInspectionDetails() {
        return inspectionDetails;
    }

    public void setInspectionDetails(List<InspectionDetailDTO> inspectionDetails) {
        this.inspectionDetails = inspectionDetails;
    }

    public List<InspectionEntryDTO> getInspectionEntries() {
        return inspectionEntries;
    }

    public void setInspectionEntries(List<InspectionEntryDTO> inspectionEntries) {
        this.inspectionEntries = inspectionEntries;
    }

    
}