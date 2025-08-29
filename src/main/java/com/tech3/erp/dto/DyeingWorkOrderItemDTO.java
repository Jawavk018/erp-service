package com.tech3.erp.dto;

import com.tech3.erp.entity.DyeingWorkOrderItem;

public class DyeingWorkOrderItemDTO {

    private Long id;
    private Long dyeingWorkOrderId;
    private Long finishedFabricCodeId;
    private String finishedFabricName;
    private Long greigeFabricCodeId;
    private String greigeFabricName;
    private Double quantity;
    private Double costPerPound;
    private Double totalAmount;
    private Long colorId;
    private String pantone;
    private Double finishedWeight;
    private Integer greigeWidth;
    private Integer reqFinishedWidth;
    private Long uomId;
    private String remarks;
    private Boolean activeFlag;

    public DyeingWorkOrderItemDTO() {}

    public DyeingWorkOrderItemDTO(DyeingWorkOrderItem entity) {
        this.id = entity.getId();
        this.finishedFabricCodeId = entity.getFinishedFabricCodeId();
        this.finishedFabricName = entity.getFinishedFabricName();
        this.greigeFabricCodeId = entity.getGreigeFabricCodeId();
        this.greigeFabricName = entity.getGreigeFabricName();
        this.quantity = entity.getQuantity();
        this.costPerPound = entity.getCostPerPound();
        this.totalAmount = entity.getTotalAmount();
        this.colorId = entity.getColorId();
        this.pantone = entity.getPantone();
        this.finishedWeight = entity.getFinishedWeight();
        this.greigeWidth = entity.getGreigeWidth();
        this.reqFinishedWidth = entity.getReqFinishedWidth();
        this.uomId = entity.getUomId();
        this.remarks = entity.getRemarks();
        this.activeFlag = entity.getActiveFlag();
    }

    // Getters and Setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getDyeingWorkOrderId() {
        return dyeingWorkOrderId;
    }
    public void setDyeingWorkOrderId(Long dyeingWorkOrderId) {
        this.dyeingWorkOrderId = dyeingWorkOrderId;
    }

    public Long getFinishedFabricCodeId() {
        return finishedFabricCodeId;
    }
    public void setFinishedFabricCodeId(Long finishedFabricCodeId) {
        this.finishedFabricCodeId = finishedFabricCodeId;
    }

    public String getFinishedFabricName() {
        return finishedFabricName;
    }
    public void setFinishedFabricName(String finishedFabricName) {
        this.finishedFabricName = finishedFabricName;
    }

    public Long getGreigeFabricCodeId() {
        return greigeFabricCodeId;
    }
    public void setGreigeFabricCodeId(Long greigeFabricCodeId) {
        this.greigeFabricCodeId = greigeFabricCodeId;
    }

    public String getGreigeFabricName() {
        return greigeFabricName;
    }
    public void setGreigeFabricName(String greigeFabricName) {
        this.greigeFabricName = greigeFabricName;
    }

    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCostPerPound() {
        return costPerPound;
    }
    public void setCostPerPound(Double costPerPound) {
        this.costPerPound = costPerPound;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getColorId() {
        return colorId;
    }
    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getPantone() {
        return pantone;
    }
    public void setPantone(String pantone) {
        this.pantone = pantone;
    }

    public Double getFinishedWeight() {
        return finishedWeight;
    }
    public void setFinishedWeight(Double finishedWeight) {
        this.finishedWeight = finishedWeight;
    }

    public Integer getGreigeWidth() {
        return greigeWidth;
    }
    public void setGreigeWidth(Integer greigeWidth) {
        this.greigeWidth = greigeWidth;
    }

    public Integer getReqFinishedWidth() {
        return reqFinishedWidth;
    }
    public void setReqFinishedWidth(Integer reqFinishedWidth) {
        this.reqFinishedWidth = reqFinishedWidth;
    }

    public Long getUomId() {
        return uomId;
    }
    public void setUomId(Long uomId) {
        this.uomId = uomId;
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

}
