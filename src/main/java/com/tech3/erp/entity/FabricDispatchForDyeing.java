package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fabric_dispatch_for_dyeing", schema = "masters")
public class FabricDispatchForDyeing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fabricDispatchDate;
    private Long vendorId;
    private Long dyeingWorkOrderId;
    private Double orderQuantity;
    private Double dispatchedQuantity;
    private Double receivedQuantity;
    private Double balanceQuantity;
    private Double costPerPound;
    private Double totalAmount;
    private Long colorId;
    private String pantone;
    private Long finishingId;
    private Long salesOrderId;
    private Long shipmentModeId;
    private Long lotId;
    private String remarks;
    private Boolean activeFlag;

    // Default Constructor
    public FabricDispatchForDyeing() {}

    // Constructor with all fields
    public FabricDispatchForDyeing(Long id, LocalDate fabricDispatchDate, Long vendorId, Long dyeingWorkOrderId,
                                   Double orderQuantity, Double dispatchedQuantity, Double receivedQuantity,
                                   Double balanceQuantity, Double costPerPound, Double totalAmount, Long colorId,
                                   String pantone, Long finishingId, Long salesOrderId, Long shipmentModeId,
                                   Long lotId, String remarks, Boolean activeFlag) {
        this.id = id;
        this.fabricDispatchDate = fabricDispatchDate;
        this.vendorId = vendorId;
        this.dyeingWorkOrderId = dyeingWorkOrderId;
        this.orderQuantity = orderQuantity;
        this.dispatchedQuantity = dispatchedQuantity;
        this.receivedQuantity = receivedQuantity;
        this.balanceQuantity = balanceQuantity;
        this.costPerPound = costPerPound;
        this.totalAmount = totalAmount;
        this.colorId = colorId;
        this.pantone = pantone;
        this.finishingId = finishingId;
        this.salesOrderId = salesOrderId;
        this.shipmentModeId = shipmentModeId;
        this.lotId = lotId;
        this.remarks = remarks;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFabricDispatchDate() { return fabricDispatchDate; }
    public void setFabricDispatchDate(LocalDate fabricDispatchDate) { this.fabricDispatchDate = fabricDispatchDate; }

    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public Long getDyeingWorkOrderId() { return dyeingWorkOrderId; }
    public void setDyeingWorkOrderId(Long dyeingWorkOrderId) { this.dyeingWorkOrderId = dyeingWorkOrderId; }

    public Double getOrderQuantity() { return orderQuantity; }
    public void setOrderQuantity(Double orderQuantity) { this.orderQuantity = orderQuantity; }

    public Double getDispatchedQuantity() { return dispatchedQuantity; }
    public void setDispatchedQuantity(Double dispatchedQuantity) { this.dispatchedQuantity = dispatchedQuantity; }

    public Double getReceivedQuantity() { return receivedQuantity; }
    public void setReceivedQuantity(Double receivedQuantity) { this.receivedQuantity = receivedQuantity; }

    public Double getBalanceQuantity() { return balanceQuantity; }
    public void setBalanceQuantity(Double balanceQuantity) { this.balanceQuantity = balanceQuantity; }

    public Double getCostPerPound() { return costPerPound; }
    public void setCostPerPound(Double costPerPound) { this.costPerPound = costPerPound; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Long getColorId() { return colorId; }
    public void setColorId(Long colorId) { this.colorId = colorId; }

    public String getPantone() { return pantone; }
    public void setPantone(String pantone) { this.pantone = pantone; }

    public Long getFinishingId() { return finishingId; }
    public void setFinishingId(Long finishingId) { this.finishingId = finishingId; }

    public Long getSalesOrderId() { return salesOrderId; }
    public void setSalesOrderId(Long salesOrderId) { this.salesOrderId = salesOrderId; }

    public Long getShipmentModeId() { return shipmentModeId; }
    public void setShipmentModeId(Long shipmentModeId) { this.shipmentModeId = shipmentModeId; }

    public Long getLotId() { return lotId; }
    public void setLotId(Long lotId) { this.lotId = lotId; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(Boolean activeFlag) { this.activeFlag = activeFlag; }
}
