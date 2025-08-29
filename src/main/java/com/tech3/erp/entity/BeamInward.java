package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "beam_inward", schema = "masters")
public class BeamInward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vendorId;
    private Long sizingPlanId;
    private Long termsConditionsId;
    private Long consigneeId;
    private Long paymentTermsId;
    private Double sizingRate;

    @Column(columnDefinition = "text")
    private String remarks;

    private String beamInwardNo;

    @OneToMany(mappedBy = "beamInward", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BeamInwardQualityDetails> qualityDetails;

    @OneToMany(mappedBy = "beamInward", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BeamInwardBeamDetails> beamDetails;

    @PrePersist
    public void prePersist() {
        if (this.beamInwardNo == null || this.beamInwardNo.isEmpty()) {
            this.beamInwardNo = generateBeamInwardNo();
        }
    }

    private String generateBeamInwardNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "BI-" + datePart + "-" + randomNum;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getSizingPlanId() {
        return sizingPlanId;
    }

    public void setSizingPlanId(Long sizingPlanId) {
        this.sizingPlanId = sizingPlanId;
    }
    
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

    public String getBeamInwardNo() { return beamInwardNo; }

    public void setBeamInwardNo(String beamInwardNo) { this.beamInwardNo = beamInwardNo; }

    public List<BeamInwardQualityDetails> getQualityDetails() { return qualityDetails; }

    public void setQualityDetails(List<BeamInwardQualityDetails> qualityDetails) { this.qualityDetails = qualityDetails; }

    public List<BeamInwardBeamDetails> getBeamDetails() { return beamDetails; }

    public void setBeamDetails(List<BeamInwardBeamDetails> beamDetails) { this.beamDetails = beamDetails; }
}
