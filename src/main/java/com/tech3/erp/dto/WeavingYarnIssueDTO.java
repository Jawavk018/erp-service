// package com.tech3.erp.dto;

// import java.math.BigDecimal;

// public class YarnRequirementDTO {

//     private String yarnType;
//     private String yarnCount;
//     private BigDecimal gramsPerMeter;
//     private BigDecimal totalWeavingOrderQty;
//     private BigDecimal totalRequiredQty;
//     private BigDecimal totalAvailableQty;
//     private Boolean activeFlag = true;

//     public String getYarnType() {
//         return yarnType;
//     }

//     public void setYarnType(String yarnType) {
//         this.yarnType = yarnType;
//     }

//     public String getYarnCount() {
//         return yarnCount;
//     }

//     public void setYarnCount(String yarnCount) {
//         this.yarnCount = yarnCount;
//     }

//     public BigDecimal getGramsPerMeter() {
//         return gramsPerMeter;
//     }

//     public void setGramsPerMeter(BigDecimal gramsPerMeter) {
//         this.gramsPerMeter = gramsPerMeter;
//     }

//     public BigDecimal getTotalWeavingOrderQty() {
//         return totalWeavingOrderQty;
//     }

//     public void setTotalWeavingOrderQty(BigDecimal totalWeavingOrderQty) {
//         this.totalWeavingOrderQty = totalWeavingOrderQty;
//     }

//     public BigDecimal getTotalRequiredQty() {
//         return totalRequiredQty;
//     }

//     public void setTotalRequiredQty(BigDecimal totalRequiredQty) {
//         this.totalRequiredQty = totalRequiredQty;
//     }

//     public BigDecimal getTotalAvailableQty() {
//         return totalAvailableQty;
//     }

//     public void setTotalAvailableQty(BigDecimal totalAvailableQty) {
//         this.totalAvailableQty = totalAvailableQty;
//     }

//     public Boolean getActiveFlag() {
//         return activeFlag;
//     }

//     public void setActiveFlag(Boolean activeFlag) {
//         this.activeFlag = activeFlag;
//     }
// }




package com.tech3.erp.dto;

import java.time.LocalDate;
import java.util.List;

public class WeavingYarnIssueDTO {
    private Long id;
    private Long vendorId;
    private Long weavingContractId;
    private String transportationDetails;
    private Long termsConditionsId;
    private String fabricDetails;
    private LocalDate yarnIssueDate;
    private String yarnIssueChallanNo;
    private boolean activeFlag;

    private List<WeavingYarnRequirementDTO> requirements;

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

    public Long getWeavingContractId() {
        return weavingContractId;
    }

    public void setWeavingContractId(Long weavingContractId) {
        this.weavingContractId = weavingContractId;
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

    public LocalDate getYarnIssueDate() {
        return yarnIssueDate;
    }

    public void setYarnIssueDate(LocalDate yarnIssueDate) {
        this.yarnIssueDate = yarnIssueDate;
    }

    public String getYarnIssueChallanNo() {
        return yarnIssueChallanNo;
    }

    public void setYarnIssueChallanNo(String yarnIssueChallanNo) {
        this.yarnIssueChallanNo = yarnIssueChallanNo;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
    public List<WeavingYarnRequirementDTO> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<WeavingYarnRequirementDTO> requirements) {
        this.requirements = requirements;
    }
    
}