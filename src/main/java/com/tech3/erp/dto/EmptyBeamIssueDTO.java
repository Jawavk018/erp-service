package com.tech3.erp.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmptyBeamIssueDTO {
	
	private Long id;
    private String emptyBeamNo;
    private Date emptyBeamIssueDate;
    private Long vendorId;
    private Long consigneeId;
    private String vechileNo;

    private List<EmptyBeamIssueItemDTO> items;
    
    // Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmptyBeamNo() {
        return emptyBeamNo;
    }
    
    public void setEmptyBeamNo(String emptyBeamNo) {
        this.emptyBeamNo = emptyBeamNo;
    }
    
    public Date getEmptyBeamIssueDate() {
        return emptyBeamIssueDate;
    }

    public void setEmptyBeamIssueDate(Date emptyBeamIssueDate) {
        this.emptyBeamIssueDate = emptyBeamIssueDate;
    }

    public Long getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Long consigneeId) {
        this.consigneeId = consigneeId;
    }
    
    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVechileNo() {
        return vechileNo;
    }

    public void setVechileNo(String vechileNo) {
        this.vechileNo = vechileNo;
    }
    
    public List<EmptyBeamIssueItemDTO> getItems() {
        return items;
    }

    public void setItems(List<EmptyBeamIssueItemDTO> items) {
        this.items = items;
    }

}
