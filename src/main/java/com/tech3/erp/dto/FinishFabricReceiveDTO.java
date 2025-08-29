package com.tech3.erp.dto;

import java.time.LocalDate;
import java.util.List;

public class FinishFabricReceiveDTO {
    private Long id;
    private LocalDate fabricReceiveDate;
    private Long vendorId;
    private Long dyeingWorkOrderId;
    private Double orderQuantity;
    private Double costPerPound;
    private Double totalAmount;
    private Long colorId;
    private String pantone;
    private Long finishingId;
    private Long salesOrderId;
    private Long purchaseInwardId;
    private Double dispatchedQuantity;
    private Double receivedQuantity;
    private Double balanceQuantity;
    private String remarks;
    private Boolean activeFlag;
    private List<FinishFabricReceiveItemDTO> items;

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getFabricReceiveDate() {
        return fabricReceiveDate;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public Long getDyeingWorkOrderId() {
        return dyeingWorkOrderId;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }

    public Double getCostPerPound() {
        return costPerPound;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Long getColorId() {
        return colorId;
    }

    public String getPantone() {
        return pantone;
    }

    public Long getFinishingId() {
        return finishingId;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public Long getPurchaseInwardId() {
        return purchaseInwardId;
    }

    public Double getDispatchedQuantity() {
        return dispatchedQuantity;
    }

    public Double getReceivedQuantity() {
        return receivedQuantity;
    }

    public Double getBalanceQuantity() {
        return balanceQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public List<FinishFabricReceiveItemDTO> getItems() {
        return items;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFabricReceiveDate(LocalDate fabricReceiveDate) {
        this.fabricReceiveDate = fabricReceiveDate;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public void setDyeingWorkOrderId(Long dyeingWorkOrderId) {
        this.dyeingWorkOrderId = dyeingWorkOrderId;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setCostPerPound(Double costPerPound) {
        this.costPerPound = costPerPound;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public void setPantone(String pantone) {
        this.pantone = pantone;
    }

    public void setFinishingId(Long finishingId) {
        this.finishingId = finishingId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public void setPurchaseInwardId(Long purchaseInwardId) {
        this.purchaseInwardId = purchaseInwardId;
    }

    public void setDispatchedQuantity(Double dispatchedQuantity) {
        this.dispatchedQuantity = dispatchedQuantity;
    }

    public void setReceivedQuantity(Double receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public void setBalanceQuantity(Double balanceQuantity) {
        this.balanceQuantity = balanceQuantity;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public void setItems(List<FinishFabricReceiveItemDTO> items) {
        this.items = items;
    }
}