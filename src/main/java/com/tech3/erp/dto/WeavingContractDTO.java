// package com.tech3.erp.dto;


// import java.util.List;

// public class WeavingContractDTO {

//     private Long salesOrderNo;
//     private Long vendorId;
//     private Long termsConditionsId;
//     private Long paymentTermsId;
//     private String remarks;
//     private List<WeavingContractItemDTO> items;
//     private List<YarnRequirementDTO> yarnRequirements;

//     // Getters and Setters

//     public Long getSalesOrderNo() {
//         return salesOrderNo;
//     }

//     public void setSalesOrderNo(Long salesOrderNo) {
//         this.salesOrderNo = salesOrderNo;
//     }

//     public Long getVendorId() {
//         return vendorId;
//     }

//     public void setVendorId(Long vendorId) {
//         this.vendorId = vendorId;
//     }

//     public Long getTermsConditionsId() {
//         return termsConditionsId;
//     }

//     public void setTermsConditionsId(Long termsConditionsId) {
//         this.termsConditionsId = termsConditionsId;
//     }

//     public Long getPaymentTermsId() {
//         return paymentTermsId;
//     }

//     public void setPaymentTermsId(Long paymentTermsId) {
//         this.paymentTermsId = paymentTermsId;
//     }

//     public String getRemarks() {
//         return remarks;
//     }

//     public void setRemarks(String remarks) {
//         this.remarks = remarks;
//     }

//     public List<WeavingContractItemDTO> getItems() {
//         return items;
//     }

//     public void setItems(List<WeavingContractItemDTO> items) {
//         this.items = items;
//     }

//     public List<YarnRequirementDTO> getYarnRequirements() {
//         return yarnRequirements;
//     }

//     public void setYarnRequirements(List<YarnRequirementDTO> yarnRequirements) {
//         this.yarnRequirements = yarnRequirements;
//     }
// }



package com.tech3.erp.dto;

import java.util.List;

public class WeavingContractDTO {

    private Long id;
    private String weavingContractNo;
    private Long salesOrderNo;
    private Long vendorId;
    private Long termsConditionsId;
    private Long paymentTermsId;
    private String remarks;
    private Boolean activeFlag;
    private List<WeavingContractItemDTO> items;
    private List<YarnRequirementDTO> yarnRequirements;

    // Constructors
    public WeavingContractDTO() {}

    // If you want to create this DTO from an Entity:
    /*
    public WeavingContractDTO(WeavingContract contract) {
        this.id = contract.getId();
        this.weavingContractNo = contract.getWeavingContractNo();
        this.salesOrderNo = contract.getSalesOrderNo();
        this.vendorId = contract.getVendorId();
        this.termsConditionsId = contract.getTermsConditionsId();
        this.paymentTermsId = contract.getPaymentTermsId();
        this.remarks = contract.getRemarks();
        this.activeFlag = contract.getActiveFlag();
        this.items = contract.getItems().stream().map(WeavingContractItemDTO::new).collect(Collectors.toList());
        this.yarnRequirements = contract.getYarnRequirements().stream().map(YarnRequirementDTO::new).collect(Collectors.toList());
    }
    */

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeavingContractNo() {
        return weavingContractNo;
    }

    public void setWeavingContractNo(String weavingContractNo) {
        this.weavingContractNo = weavingContractNo;
    }

    public Long getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(Long salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getTermsConditionsId() {
        return termsConditionsId;
    }

    public void setTermsConditionsId(Long termsConditionsId) {
        this.termsConditionsId = termsConditionsId;
    }

    public Long getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Long paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<WeavingContractItemDTO> getItems() {
        return items;
    }

    public void setItems(List<WeavingContractItemDTO> items) {
        this.items = items;
    }

    public List<YarnRequirementDTO> getYarnRequirements() {
        return yarnRequirements;
    }

    public void setYarnRequirements(List<YarnRequirementDTO> yarnRequirements) {
        this.yarnRequirements = yarnRequirements;
    }
}

