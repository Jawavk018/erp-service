package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade_master", schema = "masters")
public class GradeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "grade_code", nullable = false, length = 50)
    private String gradeCode;

    @Column(name = "grade_name", nullable = false, length = 100)
    private String gradeName;
    
    @Column(name = "min_point")
    private Short minPoint;
    
    @Column(name = "max_point")
    private Short maxPoint;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
    
    public Short getMinPoint() {
    	return minPoint;
    }
    
    public void setMinPoint(Short minPoint) {
    	this.minPoint = minPoint;
    }

    public Short getMaxPoint() {
    	return maxPoint;
    }
    
    public void setMaxPoint(Short maxPoint) {
    	this.maxPoint = maxPoint;
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
}