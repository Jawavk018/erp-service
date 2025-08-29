package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity   
@Table(name = "sizing_yarn_issue", schema = "masters")
public class SizingYarnIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizing_yarn_issue_entry_id")
    private SizingYarnIssueEntry sizingYarnIssueEntry;

    @Column(name = "lot_id")
    private Long lotId;

    @Column(name = "yarn_name", length = 100, nullable = false)
    private String yarnName;

    @Column(name = "available_req_qty", precision = 38, scale = 2)
    private BigDecimal availableReqQty;

    @Column(name = "issue_qty", precision = 38, scale = 2)
    private BigDecimal issueQty;

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
    

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public String getYarnName() {
        return yarnName;
    }

    public void setYarnName(String yarnName) {
        this.yarnName = yarnName;
    }

    public BigDecimal getAvailableReqQty() {
        return availableReqQty;
    }

    public void setAvailableReqQty(BigDecimal availableReqQty) {
        this.availableReqQty = availableReqQty;
    }

    public BigDecimal getIssueQty() {
        return issueQty;
    }

    public void setIssueQty(BigDecimal issueQty) {
        this.issueQty = issueQty;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}