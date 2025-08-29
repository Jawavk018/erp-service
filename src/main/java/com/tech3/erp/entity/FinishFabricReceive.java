package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.tech3.erp.dto.FinishFabricReceiveItemDTO;

@Entity
@Table(name = "finish_fabric_receive", schema = "masters")
public class FinishFabricReceive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fabric_fabric_receive_date")
    private LocalDate fabricReceiveDate;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "dyeing_work_order_id")
    private Long dyeingWorkOrderId;

    @Column(name = "order_quantity")
    private Double orderQuantity;

    @Column(name = "cost_per_pound")
    private Double costPerPound;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "color_id")
    private Long colorId;

    @Column(name = "pantone")
    private String pantone;

    @Column(name = "finishing_id")
    private Long finishingId;

    @Column(name = "sales_order_id")
    private Long salesOrderId;

    @Column(name = "purchase_inward_id")
    private Long purchaseInwardId;

    @Column(name = "dispatched_quantity")
    private Double dispatchedQuantity;

    @Column(name = "received_quantity")
    private Double receivedQuantity;

    @Column(name = "balance_quantity")
    private Double balanceQuantity;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    @OneToMany(mappedBy = "finishFabricReceive", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FinishFabricReceiveItem> items;

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

    public List<FinishFabricReceiveItem> getItems() {
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

    public void setItems(List<FinishFabricReceiveItem> items) {
        this.items = items;
    }
}
