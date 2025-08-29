package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sizing_plan", schema = "masters")
public class SizingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vendorId;
    private Long termsConditionsId;
    private Long consigneeId;
    private Long paymentTermsId;
    private Double sizingRate;

    @Column(columnDefinition = "text")
    private String remarks;

    private String sizingPlanNo;

    @OneToMany(mappedBy = "sizingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SizingQualityDetails> qualityDetails;

    @OneToMany(mappedBy = "sizingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SizingBeamDetails> beamDetails;

    @PrePersist
    public void prePersist() {
        if (this.sizingPlanNo == null || this.sizingPlanNo.isEmpty()) {
            this.sizingPlanNo = generateSizingPlanNo();
        }
    }

    private String generateSizingPlanNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "SP-" + datePart + "-" + randomNum;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getVendorId() { return vendorId; }

    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public Long getTermsConditionsId() { return termsConditionsId; }

    public void setTermsConditionsId(Long termsConditionsId) { this.termsConditionsId = termsConditionsId; }

    public Long getConsigneeId() { return consigneeId; }

    public void setConsigneeId(Long consigneeId) { this.consigneeId = consigneeId; }

    public Long getPaymentTermsId() { return paymentTermsId; }

    public void setPaymentTermsId(Long paymentTermsId) { this.paymentTermsId = paymentTermsId; }

    public Double getSizingRate() { return sizingRate; }

    public void setSizingRate(Double sizingRate) { this.sizingRate = sizingRate; }

    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks; }

    public String getSizingPlanNo() { return sizingPlanNo; }

    public void setSizingPlanNo(String sizingPlanNo) { this.sizingPlanNo = sizingPlanNo; }

    public List<SizingQualityDetails> getQualityDetails() { return qualityDetails; }

    public void setQualityDetails(List<SizingQualityDetails> qualityDetails) { this.qualityDetails = qualityDetails; }

    public List<SizingBeamDetails> getBeamDetails() { return beamDetails; }

    public void setBeamDetails(List<SizingBeamDetails> beamDetails) { this.beamDetails = beamDetails; }
}
