package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "yarn_requirement", schema = "masters")
public class YarnRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "weaving_contract_id")
    @JsonBackReference
    private WeavingContract weavingContract;

    private String yarnType;
    private String yarnCount;
    private BigDecimal gramsPerMeter;
    private BigDecimal totalWeavingOrderQty;
    private BigDecimal totalRequiredQty;
    private BigDecimal totalAvailableQty;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeavingContract getWeavingContract() {
        return weavingContract;
    }

    public void setWeavingContract(WeavingContract weavingContract) {
        this.weavingContract = weavingContract;
    }

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
