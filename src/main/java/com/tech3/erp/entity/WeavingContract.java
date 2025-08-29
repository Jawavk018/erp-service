package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "weaving_contract", schema = "masters")
public class WeavingContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weaving_contract_no", unique = true, nullable = false)
    private String weavingContractNo;

    @Column(name = "sales_order_no", nullable = false)
    private Long salesOrderNo;

    @Column(name = "vendor_id", nullable = false)
    private Long vendorId;

    @Column(name = "terms_conditions_id")
    private Long termsConditionsId;

    @Column(name = "payment_terms_id")
    private Long paymentTermsId;

    private String remarks;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    @OneToMany(mappedBy = "weavingContract", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<WeavingContractItem> items;

    @OneToMany(mappedBy = "weavingContract", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<YarnRequirement> yarnRequirements;

    @PrePersist
    public void prePersist() {
        if (this.weavingContractNo == null || this.weavingContractNo.isEmpty()) {
            this.weavingContractNo = generateWeavingContractNo();
        }
    }

    private String generateWeavingContractNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "WC-" + datePart + "-" + randomNum;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeavingContractNo() {
        return weavingContractNo;
    }

    public void setWeavingContractNo(String weavingContractNo) {
        this.weavingContractNo = weavingContractNo;
    }

    public Long getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(Long salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getTermsConditionsId() {
        return termsConditionsId;
    }

    public void setTermsConditionsId(Long termsConditionsId) {
        this.termsConditionsId = termsConditionsId;
    }

    public Long getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Long paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
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

    public List<WeavingContractItem> getItems() {
        return items;
    }

    public void setItems(List<WeavingContractItem> items) {
        this.items = items;
    }

    public List<YarnRequirement> getYarnRequirements() {
        return yarnRequirements;
    }

    public void setYarnRequirements(List<YarnRequirement> yarnRequirements) {
        this.yarnRequirements = yarnRequirements;
    }
}
