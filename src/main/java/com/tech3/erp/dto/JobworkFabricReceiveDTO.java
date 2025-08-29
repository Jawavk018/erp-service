package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.JobworkFabricReceive;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JobworkFabricReceiveDTO {

    private Long id;
    private Long weavingContractId;
    private Long vendorId;
    private LocalDate jobFabricReceiveDate;
    private String remarks;
    private Boolean activeFlag;

    @JsonProperty("jobworkFabricReceiveItemsDtl")
    private List<JobworkFabricReceiveItemDTO> jobworkFabricReceiveItemsDtl;

    public JobworkFabricReceiveDTO() {}

    public JobworkFabricReceiveDTO(JobworkFabricReceive jobworkFabricReceive) {
        this.id = jobworkFabricReceive.getId();
        this.weavingContractId = jobworkFabricReceive.getWeavingContractId();
        this.vendorId = jobworkFabricReceive.getVendorId();
        this.jobFabricReceiveDate = jobworkFabricReceive.getJobFabricReceiveDate();
        this.remarks = jobworkFabricReceive.getRemarks();
        this.activeFlag = jobworkFabricReceive.getActiveFlag();
        if (jobworkFabricReceive.getItems() != null) {
            this.jobworkFabricReceiveItemsDtl = jobworkFabricReceive.getItems().stream()
                .map(JobworkFabricReceiveItemDTO::new)
                .collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeavingContractId() {
        return weavingContractId;
    }

    public void setWeavingContractId(Long weavingContractId) {
        this.weavingContractId = weavingContractId;
    }
    
    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public LocalDate getJobFabricReceiveDate() {
        return jobFabricReceiveDate;
    }

    public void setJobFabricReceiveDate(LocalDate jobFabricReceiveDate) {
        this.jobFabricReceiveDate = jobFabricReceiveDate;
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

    public List<JobworkFabricReceiveItemDTO> getJobworkFabricReceiveItemsDtl() {
        return jobworkFabricReceiveItemsDtl;
    }

    public void setJobworkFabricReceiveItemsDtl(List<JobworkFabricReceiveItemDTO> jobworkFabricReceiveItemsDtl) {
        this.jobworkFabricReceiveItemsDtl = jobworkFabricReceiveItemsDtl;
    }

}
