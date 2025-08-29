package com.tech3.erp.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sizing_yarn_requirement", schema = "masters")
public class SizingYarnRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizing_yarn_issue_entry_id")
    private SizingYarnIssueEntry sizingYarnIssueEntry;

    @Column(name = "yarn_name", length = 100, nullable = false)
    private String yarnName;

    @Column(name = "yarn_count")
    private Long yarnCount;

    @Column(name = "grams_per_meter", precision = 38, scale = 2)
    private BigDecimal gramsPerMeter;

    @Column(name = "total_req_qty", precision = 38, scale = 2)
    private BigDecimal totalReqQty;

    @Column(name = "total_issue_qty", precision = 38, scale = 2)
    private BigDecimal totalIssueQty;

    @Column(name = "balance_to_issue", precision = 38, scale = 2)
    private BigDecimal balanceToIssue;

    @Column(name = "active_flag")
    private boolean activeFlag = true;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SizingYarnIssueEntry getSizingYarnIssueEntry() {
        return sizingYarnIssueEntry;
    }

    public void setSizingYarnIssueEntry(SizingYarnIssueEntry sizingYarnIssueEntry) {
        this.sizingYarnIssueEntry = sizingYarnIssueEntry;
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

    
    
}