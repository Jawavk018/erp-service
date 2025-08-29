package com.tech3.erp.dto;

import java.math.BigDecimal;

public class YarnRequirementDTO {

    private String yarnType;
    private String yarnCount;
    private BigDecimal gramsPerMeter;
    private BigDecimal totalWeavingOrderQty;
    private BigDecimal totalRequiredQty;
    private BigDecimal totalAvailableQty;
    private Boolean activeFlag = true;

    public String getYarnType() {
        return yarnType;
    }

    public void setYarnType(String yarnType) {
        this.yarnType = yarnType;
    }

    public String getYarnCount() {
        return yarnCount;
    }

    public void setYarnCount(String yarnCount) {
        this.yarnCount = yarnCount;
    }

    public BigDecimal getGramsPerMeter() {
        return gramsPerMeter;
    }

    public void setGramsPerMeter(BigDecimal gramsPerMeter) {
        this.gramsPerMeter = gramsPerMeter;
    }

    public BigDecimal getTotalWeavingOrderQty() {
        return totalWeavingOrderQty;
    }

    public void setTotalWeavingOrderQty(BigDecimal totalWeavingOrderQty) {
        this.totalWeavingOrderQty = totalWeavingOrderQty;
    }

    public BigDecimal getTotalRequiredQty() {
        return totalRequiredQty;
    }

    public void setTotalRequiredQty(BigDecimal totalRequiredQty) {
        this.totalRequiredQty = totalRequiredQty;
    }

    public BigDecimal getTotalAvailableQty() {
        return totalAvailableQty;
    }

    public void setTotalAvailableQty(BigDecimal totalAvailableQty) {
        this.totalAvailableQty = totalAvailableQty;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}

