package com.tech3.erp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "inspection_entry", schema = "masters")

public class InspectionEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fabric_inspection_id", referencedColumnName = "id")
    @JsonBackReference
    private FabricInspection fabricInspection;

    @Column(name = "defected_meters")
    private Double defectedMeters;

    @Column(name = "from_meters")
    private Double fromMeters;

    @Column(name = "to_meters")
    private Double toMeters;

    @Column(name = "defect_type_id")
    private Long defectTypeId;

    @Column(name = "defect_points")
    private Double defectPoints;

    @Column(name = "inspection_id")
    private Long inspectionId;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FabricInspection getFabricInspection() {
        return fabricInspection;
    }

    public void setFabricInspection(FabricInspection fabricInspection) {
        this.fabricInspection = fabricInspection;
    }

    public Double getDefectedMeters() {
        return defectedMeters;
    }

    public void setDefectedMeters(Double defectedMeters) {
        this.defectedMeters = defectedMeters;
    }

    public Double getFromMeters() {
        return fromMeters;
    }

    public void setFromMeters(Double fromMeters) {
        this.fromMeters = fromMeters;
    }

    public Double getToMeters() {
        return toMeters;
    }

    public void setToMeters(Double toMeters) {
        this.toMeters = toMeters;
    }

    public Long getDefectTypeId() {
        return defectTypeId;
    }

    public void setDefectTypeId(Long defectTypeId) {
        this.defectTypeId = defectTypeId;
    }

    public Double getDefectPoints() {
        return defectPoints;
    }

    public void setDefectPoints(Double defectPoints) {
        this.defectPoints = defectPoints;
    }

    public Long getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

}