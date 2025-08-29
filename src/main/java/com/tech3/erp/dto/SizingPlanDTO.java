package com.tech3.erp.dto;

import java.util.Date;
import java.util.List;

public class SizingPlanDTO {
    private Long id;
    private Long vendorId;
    private Long termsConditionsId;
    private Long consigneeId;
    private Long paymentTermsId;
    private Double sizingRate;
    private String emptyBeamNo;
    private String remarks;
    private String sizingPlanNo;

    private List<SizingQualityDetailsDTO> sizingQualityDetails;
    private List<SizingBeamDetailsDTO> sizingBeamDetails;

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

    public String getEmptyBeamNo() {
        return emptyBeamNo;
    }

    public void setEmptyBeamNo(String emptyBeamNo) {
        this.emptyBeamNo = emptyBeamNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSizingPlanNo() {
        return sizingPlanNo;
    }

    public void setSizingPlanNo(String sizingPlanNo) {
        this.sizingPlanNo = sizingPlanNo;
    }

    public List<SizingQualityDetailsDTO> getSizingQualityDetails() {
        return sizingQualityDetails;
    }

    public void setSizingQualityDetails(List<SizingQualityDetailsDTO> sizingQualityDetails) {
        this.sizingQualityDetails = sizingQualityDetails;
    }

    public List<SizingBeamDetailsDTO> getSizingBeamDetails() {
        return sizingBeamDetails;
    }

    public void setSizingBeamDetails(List<SizingBeamDetailsDTO> sizingBeamDetails) {
        this.sizingBeamDetails = sizingBeamDetails;
    }
}
