package com.tech3.erp.dto;

import java.util.Date;
import java.util.List;

public class BeamInwardDTO {
    private Long id;
    private Long vendorId;
    private Long sizingPlanId;
    private Long termsConditionsId;
    private Long consigneeId;
    private Long paymentTermsId;
    private Double sizingRate;
    private String remarks;
    private String beamInwardNo;

    private List<BeamInwardQualityDetailsDTO> beamInwardQualityDetails;
    private List<BeamInwardBeamDetailsDTO> beamInwardBeamDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getSizingPlanId() {
        return sizingPlanId;
    }

    public void setSizingPlanId(Long sizingPlanId) {
        this.sizingPlanId = sizingPlanId;
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

    public Long getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Long consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Long getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Long paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public Double getSizingRate() {
        return sizingRate;
    }

    public void setSizingRate(Double sizingRate) {
        this.sizingRate = sizingRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBeamInwardNo() {
        return beamInwardNo;
    }

    public void setBeamInwardNo(String beamInwardNo) {
        this.beamInwardNo = beamInwardNo;
    }

    public List<BeamInwardQualityDetailsDTO> getBeamInwardQualityDetails() {
        return beamInwardQualityDetails;
    }

    public void setBeamInwardQualityDetails(List<BeamInwardQualityDetailsDTO> beamInwardQualityDetails) {
        this.beamInwardQualityDetails = beamInwardQualityDetails;
    }

    public List<BeamInwardBeamDetailsDTO> getBeamInwardBeamDetails() {
        return beamInwardBeamDetails;
    }

    public void setBeamInwardBeamDetails(List<BeamInwardBeamDetailsDTO> beamInwardBeamDetails) {
        this.beamInwardBeamDetails = beamInwardBeamDetails;
    }
}
