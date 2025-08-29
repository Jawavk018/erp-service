package com.tech3.erp.dto;

import com.tech3.erp.entity.LotEntry;

import jakarta.persistence.PrePersist;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LotEntryDTO {

    private Long id;
    private String lotNumber;
    private Long warehouseId;
    private BigDecimal quantity;
    private BigDecimal rejectedQuantity;
    private BigDecimal cost;
    private String remarks;
    private Boolean activeFlag;

    public LotEntryDTO() {}

    public LotEntryDTO(LotEntry lot) {
        this.id = lot.getId();
        this.lotNumber = lot.getLotNumber();
        this.quantity = lot.getQuantity();
        this.rejectedQuantity = lot.getRejectedQuantity();
        this.cost = lot.getCost();
        this.remarks = lot.getRemarks();
        this.activeFlag = lot.getActiveFlag();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }
    
    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(BigDecimal rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

