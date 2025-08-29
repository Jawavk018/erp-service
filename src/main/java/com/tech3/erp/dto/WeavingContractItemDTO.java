package com.tech3.erp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WeavingContractItemDTO {

    private Long fabricCodeId;
    private Long fabricQualityId;
    private BigDecimal quantity;
    private BigDecimal pickCost;
    private LocalDate plannedStartDate;
    private LocalDate plannedEndDate;
    private BigDecimal dailyTarget;
    private Integer numberOfLooms;
    private BigDecimal warpLength;
    private BigDecimal warpCrimpPercentage;
    private BigDecimal pieceLength;
    private Integer numberOfPieces;
    private Boolean activeFlag = true;

    public Long getFabricCodeId() {
        return fabricCodeId;
    }

    public void setFabricCodeId(Long fabricCodeId) {
        this.fabricCodeId = fabricCodeId;
    }

    public Long getFabricQualityId() {
        return fabricQualityId;
    }

    public void setFabricQualityId(Long fabricQualityId) {
        this.fabricQualityId = fabricQualityId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPickCost() {
        return pickCost;
    }

    public void setPickCost(BigDecimal pickCost) {
        this.pickCost = pickCost;
    }

    public LocalDate getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(LocalDate plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public LocalDate getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(LocalDate plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public BigDecimal getDailyTarget() {
        return dailyTarget;
    }

    public void setDailyTarget(BigDecimal dailyTarget) {
        this.dailyTarget = dailyTarget;
    }

    public Integer getNumberOfLooms() {
        return numberOfLooms;
    }

    public void setNumberOfLooms(Integer numberOfLooms) {
        this.numberOfLooms = numberOfLooms;
    }

    public BigDecimal getWarpLength() {
        return warpLength;
    }

    public void setWarpLength(BigDecimal warpLength) {
        this.warpLength = warpLength;
    }

    public BigDecimal getWarpCrimpPercentage() {
        return warpCrimpPercentage;
    }

    public void setWarpCrimpPercentage(BigDecimal warpCrimpPercentage) {
        this.warpCrimpPercentage = warpCrimpPercentage;
    }

    public BigDecimal getPieceLength() {
        return pieceLength;
    }

    public void setPieceLength(BigDecimal pieceLength) {
        this.pieceLength = pieceLength;
    }

    public Integer getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(Integer numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
