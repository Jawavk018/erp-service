package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "defect_master", schema = "masters")
public class DefectMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "defect_code", nullable = false, length = 50)
    private String defectCode;

    @Column(name = "defect_name", nullable = false, length = 100)
    private String defectName;
    
    @Column(name = "defect_pont")
    private Short defectPoint;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDefectCode() {
        return defectCode;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }
    
    public Short getDefectPoint() {
    	return defectPoint;
    }
    
    public void setDefectPoint(Short defectPoint) {
    	this.defectPoint = defectPoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    // For boolean fields, you might also want to add an is-method
    public Boolean isActiveFlag() {
        return activeFlag;
    }
}
