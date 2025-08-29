package com.tech3.erp.dto;

import java.time.LocalDate;
import java.util.List;

public class SizingYarnIssueEntryDTO {
    private Long id;
    private Long vendorId;
    private Long sizingPlanId;
    private String transportationDetails;
    private Long termsConditionsId;
    private String fabricDetails;
    private LocalDate sizingYarnIssueDate;
    private boolean activeFlag;

    private List<SizingYarnRequirementDTO> requirements;
	private List<SizingYarnIssueDTO> sizingYarnIssue;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getSizingPlanId() {
        return sizingPlanId;
    }

    public void setSizingPlanId(Long sizingPlanId) {
        this.sizingPlanId = sizingPlanId;
    }

    public String getTransportationDetails() {
        return transportationDetails;
    }

    public void setTransportationDetails(String transportationDetails) {
        this.transportationDetails = transportationDetails;
    }

    public Long getTermsConditionsId() {
        return termsConditionsId;
    }

    public void setTermsConditionsId(Long termsConditionsId) {
        this.termsConditionsId = termsConditionsId;
    }

    public String getFabricDetails() {
        return fabricDetails;
    }

    public void setFabricDetails(String fabricDetails) {
        this.fabricDetails = fabricDetails;
    }

    public LocalDate getSizingYarnIssueDate() {
        return sizingYarnIssueDate;
    }

    public void setSizingYarnIssueDate(LocalDate sizingYarnIssueDate) {
        this.sizingYarnIssueDate = sizingYarnIssueDate;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
    public List<SizingYarnRequirementDTO> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<SizingYarnRequirementDTO> requirements) {
        this.requirements = requirements;
    }
    
    public List<SizingYarnIssueDTO> getSizingYarnIssue() {
      return sizingYarnIssue;
  }

  public void setSizingYarnIssue(List<SizingYarnIssueDTO> sizingYarnIssue) {
      this.sizingYarnIssue = sizingYarnIssue;
  }
    
}