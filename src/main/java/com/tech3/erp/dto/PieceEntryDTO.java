//package com.tech3.erp.dto;
//
//public class LotEntryDTO {
//    private String lotNumber;
//    private Double receivedQty;
//    private Double rejectedQty;
//    private Double costPerUnit;
//
//    public String getLotNumber() {
//        return lotNumber;
//    }
//
//    public void setLotNumber(String lotNumber) {
//        this.lotNumber = lotNumber;
//    }
//
//    public Double getReceivedQty() {
//        return receivedQty;
//    }
//
//    public void setReceivedQty(Double receivedQty) {
//        this.receivedQty = receivedQty;
//    }
//
//    public Double getRejectedQty() {
//        return rejectedQty;
//    }
//
//    public void setRejectedQty(Double rejectedQty) {
//        this.rejectedQty = rejectedQty;
//    }
//
//    public Double getCostPerUnit() {
//        return costPerUnit;
//    }
//
//    public void setCostPerUnit(Double costPerUnit) {
//        this.costPerUnit = costPerUnit;
//    }
//}


package com.tech3.erp.dto;

import com.tech3.erp.entity.LotEntry;
import com.tech3.erp.entity.PieceEntry;

import java.math.BigDecimal;

public class PieceEntryDTO {

    private Long id;
    private String pieceNumber;
    private BigDecimal quantity;
    private BigDecimal weight;
    private BigDecimal cost;
    private String remarks;
    private Boolean activeFlag;

    public PieceEntryDTO() {}

    public PieceEntryDTO(PieceEntry piece) {
        this.id = piece.getId();
        this.pieceNumber = piece.getPieceNumber();
        this.quantity = piece.getQuantity();
        this.weight = piece.getWeight();
        this.cost = piece.getCost();
        this.remarks = piece.getRemarks();
        this.activeFlag = piece.getActiveFlag();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(String pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

