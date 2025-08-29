package com.tech3.erp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "fabric_inspection", schema = "masters")

public class FabricInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inspection_date")
    private LocalDate inspectionDate;

    @Column(name = "loom_no")
    private Double loomNo;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "fabric_quality", length = 100)
    private String fabricQuality;

    @Column(name = "doff_meters")
    private Double doffMeters;

    @Column(name = "doff_weight")
    private Long doffWeight;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    @OneToMany(mappedBy = "fabricInspection", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<InspectionDetail> inspectionDetails;

    @OneToMany(mappedBy = "fabricInspection", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<InspectionEntry> inspectionEntries;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Double getLoomNo() {
        return loomNo;
    }

    public void setLoomNo(Double loomNo) {
        this.loomNo = loomNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getFabricQuality() {
        return fabricQuality;
    }

    public void setFabricQuality(String fabricQuality) {
        this.fabricQuality = fabricQuality;
    }

    public Double getDoffMeters() {
        return doffMeters;
    }

    public void setDoffMeters(Double doffMeters) {
        this.doffMeters = doffMeters;
    }

    public Long getDoffWeight() {
        return doffWeight;
    }

    public void setDoffWeight(Long doffWeight) {
        this.doffWeight = doffWeight;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<InspectionDetail> getInspectionDetails() {
        return inspectionDetails;
    }

    public void setInspectionDetails(List<InspectionDetail> inspectionDetails) {
        this.inspectionDetails = inspectionDetails;
    }

    public List<InspectionEntry> getInspectionEntries() {
        return inspectionEntries;
    }

    public void setInspectionEntries(List<InspectionEntry> inspectionEntries) {
        this.inspectionEntries = inspectionEntries;
    }

    // Constructors
    public FabricInspection() {
    }

    public FabricInspection(Long id, LocalDate inspectionDate, Double loomNo, Long vendorId, String fabricQuality, Double doffMeters, Long doffWeight, Boolean activeFlag, List<InspectionDetail> inspectionDetails, List<InspectionEntry> inspectionEntries) {
        this.id = id;
        this.inspectionDate = inspectionDate;
        this.loomNo = loomNo;
        this.vendorId = vendorId;
        this.fabricQuality = fabricQuality;
        this.doffMeters = doffMeters;
        this.doffWeight = doffWeight;
        this.activeFlag = activeFlag;
        this.inspectionDetails = inspectionDetails;
        this.inspectionEntries = inspectionEntries;
    }

    // Builder pattern
    public static FabricInspectionBuilder builder() {
        return new FabricInspectionBuilder();
    }

    public static class FabricInspectionBuilder {
        private Long id;
        private LocalDate inspectionDate;
        private Double loomNo;
        private Long vendorId;
        private String fabricQuality;
        private Double doffMeters;
        private Long doffWeight;
        private Boolean activeFlag = true;
        private List<InspectionDetail> inspectionDetails;
        private List<InspectionEntry> inspectionEntries;

        FabricInspectionBuilder() {
        }

        public FabricInspectionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FabricInspectionBuilder inspectionDate(LocalDate inspectionDate) {
            this.inspectionDate = inspectionDate;
            return this;
        }

        public FabricInspectionBuilder loomNo(Double loomNo) {
            this.loomNo = loomNo;
            return this;
        }

        public FabricInspectionBuilder vendorId(Long vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public FabricInspectionBuilder fabricQuality(String fabricQuality) {
            this.fabricQuality = fabricQuality;
            return this;
        }

        public FabricInspectionBuilder doffMeters(Double doffMeters) {
            this.doffMeters = doffMeters;
            return this;
        }

        public FabricInspectionBuilder doffWeight(Long doffWeight) {
            this.doffWeight = doffWeight;
            return this;
        }

        public FabricInspectionBuilder activeFlag(Boolean activeFlag) {
            this.activeFlag = activeFlag;
            return this;
        }

        public FabricInspectionBuilder inspectionDetails(List<InspectionDetail> inspectionDetails) {
            this.inspectionDetails = inspectionDetails;
            return this;
        }

        public FabricInspectionBuilder inspectionEntries(List<InspectionEntry> inspectionEntries) {
            this.inspectionEntries = inspectionEntries;
            return this;
        }

        public FabricInspection build() {
            return new FabricInspection(id, inspectionDate, loomNo, vendorId, fabricQuality, doffMeters, doffWeight, activeFlag, inspectionDetails, inspectionEntries);
        }
    }
}