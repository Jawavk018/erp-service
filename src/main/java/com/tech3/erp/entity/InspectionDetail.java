package com.tech3.erp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "inspection_dtl", schema = "masters")

public class InspectionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fabric_inspection_id", referencedColumnName = "id")
    @JsonBackReference
    private FabricInspection fabricInspection;

    @Column(name = "roll_no", length = 100, nullable = false, unique = true)
    private String rollNo;

    @Column(name = "doff_meters")
    private Double doffMeters;

    @Column(name = "inspected_meters")
    private Double inspectedMeters;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "total_defect_points")
    private Double totalDefectPoints;

    @Column(name = "defect_counts")
    private Double defectCounts;

    @Column(name = "grade", length = 100)
    private String grade;

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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Double getDoffMeters() {
        return doffMeters;
    }

    public void setDoffMeters(Double doffMeters) {
        this.doffMeters = doffMeters;
    }

    public Double getInspectedMeters() {
        return inspectedMeters;
    }

    public void setInspectedMeters(Double inspectedMeters) {
        this.inspectedMeters = inspectedMeters;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getTotalDefectPoints() {
        return totalDefectPoints;
    }

    public void setTotalDefectPoints(Double totalDefectPoints) {
        this.totalDefectPoints = totalDefectPoints;
    }

    public Double getDefectCounts() {
        return defectCounts;
    }

    public void setDefectCounts(Double defectCounts) {
        this.defectCounts = defectCounts;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

}