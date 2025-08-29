package com.tech3.erp.dto;

import java.math.BigDecimal;

public class YarnIssueDTO {
    private Long id;
    private Long weavingYarnRequirementId;
    private Long lotId;
    private String yarnName;
    private BigDecimal availableReqQty;
    private BigDecimal issueQty;
    private boolean activeFlag;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeavingYarnRequirementId() {
        return weavingYarnRequirementId;
    }

    public void setWeavingYarnRequirementId(Long weavingYarnRequirementId) {
        this.weavingYarnRequirementId = weavingYarnRequirementId;
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