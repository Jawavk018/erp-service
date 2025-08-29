package com.tech3.erp.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.persistence.*;

@Entity
@Table(name = "weaving_yarn_issue", schema = "masters")
public class WeavingYarnIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "weaving_contract_id")
    private Long weavingContractId;

    @Column(name = "transportation_dtl", columnDefinition = "text")
    private String transportationDetails;

    @Column(name = "terms_conditions_id")
    private Long termsConditionsId;

    @Column(name = "fabric_dtl", columnDefinition = "text")
    private String fabricDetails;

    @Column(name = "yarn_issue_date")
    private LocalDate yarnIssueDate;

    @Column(name = "yarn_issue_challan_no")
    private String yarnIssueChallanNo;

    @Column(name = "active_flag")
    private boolean activeFlag = true;

    @OneToMany(mappedBy = "weavingYarnIssue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeavingYarnRequirement> requirements = new ArrayList<>();
    
    @PrePersist
    public void prePersist() {
        if (this.yarnIssueChallanNo == null || this.yarnIssueChallanNo.isEmpty()) {
            this.yarnIssueChallanNo = generateYarnIssueChallanNo();
        }
    }

    private String generateYarnIssueChallanNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "YICNO-" + datePart + "-" + randomNum;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getWeavingContractId() {
        return weavingContractId;
    }

    public void setWeavingContractId(Long weavingContractId) {
        this.weavingContractId = weavingContractId;
    }

    public String getTransportationDetails() {
        return transportationDetails;
    }

    public void setTransportationDetails(String transportationDetails) {
        this.transportationDetails = transportationDetails;
    }

    public Long getTermsConditionsId() {
        return termsConditionsId;
    }

    public void setTermsConditionsId(Long termsConditionsId) {
        this.termsConditionsId = termsConditionsId;
    }

    public String getFabricDetails() {
        return fabricDetails;
    }

    public void setFabricDetails(String fabricDetails) {
        this.fabricDetails = fabricDetails;
    }

    public LocalDate getYarnIssueDate() {
        return yarnIssueDate;
    }

    public void setYarnIssueDate(LocalDate yarnIssueDate) {
        this.yarnIssueDate = yarnIssueDate;
    }

    public String getYarnIssueChallanNo() {
        return yarnIssueChallanNo;
    }

    public void setYarnIssueChallanNo(String yarnIssueChallanNo) {
        this.yarnIssueChallanNo = yarnIssueChallanNo;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<WeavingYarnRequirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<WeavingYarnRequirement> requirements) {
        this.requirements = requirements;
    }

    public void addRequirement(WeavingYarnRequirement requirement) {
        requirements.add(requirement);
        requirement.setWeavingYarnIssue(this);
    }
    
}