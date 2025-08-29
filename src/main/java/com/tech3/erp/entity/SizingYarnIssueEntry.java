package com.tech3.erp.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.persistence.*;

@Entity
@Table(name = "sizing_yarn_issue_entry", schema = "masters")
public class SizingYarnIssueEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "sizing_plan_id")
    private Long sizingPlanId;

    @Column(name = "transportation_dtl", columnDefinition = "text")
    private String transportationDetails;

    @Column(name = "terms_conditions_id")
    private Long termsConditionsId;

    @Column(name = "fabric_dtl", columnDefinition = "text")
    private String fabricDetails;

    @Column(name = "sizing_yarn_issue_date")
    private LocalDate sizingYarnIssueDate;

    @Column(name = "active_flag")
    private boolean activeFlag = true;

    @OneToMany(mappedBy = "sizingYarnIssueEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SizingYarnRequirement> requirements = new ArrayList<>();
    
    @OneToMany(mappedBy = "sizingYarnIssueEntry", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SizingYarnIssue> sizingYarnIssue = new ArrayList<>();
    
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

    public Long getSizingPlanId() {
        return sizingPlanId;
    }

    public void setSizingPlanId(Long sizingPlanId) {
        this.sizingPlanId = sizingPlanId;
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

    public LocalDate getSizingYarnIssueDate() {
        return sizingYarnIssueDate;
    }

    public void setSizingYarnIssueDate(LocalDate sizingYarnIssueDate) {
        this.sizingYarnIssueDate = sizingYarnIssueDate;
    }
    
    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<SizingYarnRequirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<SizingYarnRequirement> requirements) {
        this.requirements = requirements;
    }

    public void addRequirement(SizingYarnRequirement requirement) {
        requirements.add(requirement);
    }
   
    public List<SizingYarnIssue> getSizingYarnIssues() {
        return sizingYarnIssue;
    }

    public void setSizingYarnIssues(List<SizingYarnIssue> sizingYarnIssue) {
        this.sizingYarnIssue = sizingYarnIssue;
    }

    public void addSizingYarnIssue(SizingYarnIssue issue) {
        sizingYarnIssue.add(issue);
        issue.setSizingYarnIssueEntry(this);
    }
    
    public void removeSizingYarnIssue(SizingYarnIssue issue) {
        sizingYarnIssue.remove(issue);
        issue.setSizingYarnIssueEntry(null);
    }
    
}