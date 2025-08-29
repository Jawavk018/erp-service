package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.PurchaseOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseOrderDTO {

    private Long id;
    private String poNo;
    private Long poTypeId;
    private LocalDate poDate;
    private Long vendorId;
    private Long taxId;
    private Boolean activeFlag;

    @JsonProperty("purchaseOrderItemsDtl")
    private List<PurchaseOrderItemDTO> purchaseOrderItemsDtl;

    public PurchaseOrderDTO() {}

    public PurchaseOrderDTO(Long id, String poNo, Long poTypeId, LocalDate poDate, Long vendorId, Long taxId,
    							Long deliveryAddressId, Boolean activeFlag,
                            List<PurchaseOrderItemDTO> purchaseOrderItemsDtl) {
        this.id = id;
        this.poNo = poNo;
        this.poTypeId = poTypeId;
        this.poDate = poDate;
        this.vendorId = vendorId;
        this.taxId = taxId;
        this.activeFlag = activeFlag;
        this.purchaseOrderItemsDtl = purchaseOrderItemsDtl;
    }

    public PurchaseOrderDTO(PurchaseOrder po) {
        this.id = po.getId();
        this.poNo = po.getPoNo();
        this.poTypeId = po.getPoTypeId();
        this.poDate = po.getPoDate();
        this.vendorId = po.getVendorId();
        this.taxId = po.getTaxId();
        this.activeFlag = po.getActiveFlag();
        if (po.getItems() != null) {
            this.purchaseOrderItemsDtl = po.getItems().stream()
                    .map(PurchaseOrderItemDTO::new)
                    .collect(Collectors.toList());
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }
    
    public Long getPoTypeId() {
        return poTypeId;
    }

    public void setPoTypeId(Long poTypeId) {
        this.poTypeId = poTypeId;
    }

    public LocalDate getPoDate() {
        return poDate;
    }

    public void setPoDate(LocalDate poDate) {
        this.poDate = poDate;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<PurchaseOrderItemDTO> getPurchaseOrderItemsDtl() {
        return purchaseOrderItemsDtl;
    }

    public void setPurchaseOrderItemsDtl(List<PurchaseOrderItemDTO> purchaseOrderItemsDtl) {
        this.purchaseOrderItemsDtl = purchaseOrderItemsDtl;
    }
}

