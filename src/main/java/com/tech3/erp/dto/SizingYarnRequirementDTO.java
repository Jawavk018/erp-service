package com.tech3.erp.dto;

import java.math.BigDecimal;
import java.util.List;

public class SizingYarnRequirementDTO {
    private Long id;
    private Long sizingYarnIssueEntryId;
    private String yarnName;
    private Long yarnCount;
    private BigDecimal gramsPerMeter;
    private BigDecimal totalReqQty;
    private BigDecimal totalIssueQty;
    private BigDecimal balanceToIssue;
    private boolean activeFlag;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSizingYarnIssueEntryId() {
        return sizingYarnIssueEntryId;
    }

    public void setSizingYarnIssueEntryId(Long sizingYarnIssueEntryId) {
        this.sizingYarnIssueEntryId = sizingYarnIssueEntryId;
    }

    public String getYarnName() {
        return yarnName;
    }

    public void setYarnName(String yarnName) {
        this.yarnName = yarnName;
    }

    public Long getYarnCount() {
        return yarnCount;
    }

    public void setYarnCount(Long yarnCount) {
        this.yarnCount = yarnCount;
    }

    public BigDecimal getGramsPerMeter() {
        return gramsPerMeter;
    }

    public void setGramsPerMeter(BigDecimal gramsPerMeter) {
        this.gramsPerMeter = gramsPerMeter;
    }

    public BigDecimal getTotalReqQty() {
        return totalReqQty;
    }

    public void setTotalReqQty(BigDecimal totalReqQty) {
        this.totalReqQty = totalReqQty;
    }

    public BigDecimal getTotalIssueQty() {
        return totalIssueQty;
    }

    public void setTotalIssueQty(BigDecimal totalIssueQty) {
        this.totalIssueQty = totalIssueQty;
    }

    public BigDecimal getBalanceToIssue() {
        return balanceToIssue;
    }

    public void setBalanceToIssue(BigDecimal balanceToIssue) {
        this.balanceToIssue = balanceToIssue;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
//    public List<SizingYarnIssueDTO> getsizingYarnIssue() {
//        return sizingYarnIssue;
//    }
//
//    public void setsizingYarnIssue(List<SizingYarnIssueDTO> sizingYarnIssue) {
//        this.sizingYarnIssue = sizingYarnIssue;
//    }
    
}