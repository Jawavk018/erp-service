package com.tech3.erp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "jobwork_fabric_receive", schema = "masters")
public class JobworkFabricReceive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weaving_contract_id")
    private Long weavingContractId;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "job_fabric_receive_date", nullable = false)
    private LocalDate jobFabricReceiveDate = LocalDate.now();

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    @OneToMany(mappedBy = "jobworkFabricReceive", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<JobworkFabricReceiveItem> items = new ArrayList<>();

    // Getters and setters

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

    public List<JobworkFabricReceiveItem> getItems() {
        return items;
    }

    public void setItems(List<JobworkFabricReceiveItem> items) {
        this.items.clear();
        if (items != null) {
            for (JobworkFabricReceiveItem item : items) {
                addItem(item);
            }
        }
    }

    public void addItem(JobworkFabricReceiveItem item) {
        item.setJobworkFabricReceive(this);
        this.items.add(item);
    }

    public void removeItem(JobworkFabricReceiveItem item) {
        item.setJobworkFabricReceive(null);
        this.items.remove(item);
    }
}

