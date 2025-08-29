//package com.tech3.erp.dto;
//
//import java.util.List;
//
//public class PurchaseInwardDTO {
//    private Long purchaseOrderId;
//    private String purchaseOrderNo;
//    private String remarks;
//    private List<PurchaseInwardItemDTO> inwardItems;
//
//    public Long getPurchaseOrderId() {
//        return purchaseOrderId;
//    }
//
//    public void setPurchaseOrderId(Long purchaseOrderId) {
//        this.purchaseOrderId = purchaseOrderId;
//    }
//
//    public String getPurchaseOrderNo() {
//        return purchaseOrderNo;
//    }
//
//    public void setPurchaseOrderNo(String purchaseOrderNo) {
//        this.purchaseOrderNo = purchaseOrderNo;
//    }
//
//    public String getRemarks() {
//        return remarks;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
//    }
//
//    public List<PurchaseInwardItemDTO> getInwardItems() {
//        return inwardItems;
//    }
//
//    public void setInwardItems(List<PurchaseInwardItemDTO> inwardItems) {
//        this.inwardItems = inwardItems;
//    }
//}



package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.PurchaseInward;
import com.tech3.erp.entity.PurchaseInwardItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseInwardDTO {

    private Long id;
    private Long poId;
    private LocalDateTime inwardDate;
    private String remarks;
    private Boolean activeFlag;

    @JsonProperty("purchaseInwardItemsDtl")
    private List<PurchaseInwardItemDTO> purchaseInwardItemsDtl;

    public PurchaseInwardDTO() {}

    public PurchaseInwardDTO(PurchaseInward inward) {
        this.id = inward.getId();
        this.poId = inward.getPurchaseOrderId();
        this.inwardDate = inward.getInwardDate();
        this.remarks = inward.getRemarks();
        this.activeFlag = inward.getActiveFlag();
        if (inward.getItems() != null) {
            this.purchaseInwardItemsDtl = inward.getItems().stream()
                .map(PurchaseInwardItemDTO::new)
                .collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseOrderId() {
        return poId;
    }

    public void setPurchaseOrderId(Long poId) {
        this.poId = poId;
    }

    public LocalDateTime getInwardDate() {
        return inwardDate;
    }

    public void setInwardDate(LocalDateTime inwardDate) {
        this.inwardDate = inwardDate;
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

    public List<PurchaseInwardItemDTO> getPurchaseInwardItemsDtl() {
        return purchaseInwardItemsDtl;
    }

    public void setPurchaseInwardItemsDtl(List<PurchaseInwardItemDTO> purchaseInwardItemsDtl) {
        this.purchaseInwardItemsDtl = purchaseInwardItemsDtl;
    }

}
