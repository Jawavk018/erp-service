package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.YarnMaster;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class YarnMasterDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String yarnName;

    @NotNull
    private Short countSno;

    private Short unitSno;

    @NotNull
    @Size(min = 1, max = 50)
    private String types;
    
    @Size(min = 1, max = 50)
    private String content;

    @NotNull
    private Double conversion;

    private boolean activeFlag;

    // Default Constructor
    public YarnMasterDTO() {}

    // Constructor with parameters
    public YarnMasterDTO(Long id, String yarnName, Short countSno, Short unitSno,  
    		String types, Double conversion, boolean activeFlag, String content) {
        this.id = id;
        this.yarnName = yarnName;
        this.countSno = countSno;
        this.unitSno = unitSno;
        this.types = types;
        this.conversion = conversion;
        this.activeFlag = activeFlag;
        this.content = content;
    }

    // Constructor to convert from entity to DTO
    public YarnMasterDTO(YarnMaster yarnMaster) {
        this.id = yarnMaster.getId();
        this.yarnName = yarnMaster.getYarnName();
        this.countSno = yarnMaster.getCountSno();
        this.unitSno = yarnMaster.getUnitSno();
        this.types = yarnMaster.getTypes();
        this.conversion = yarnMaster.getConversion();
        this.activeFlag = yarnMaster.getActiveFlag();
        this.content = yarnMaster.getContent();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYarnName() {
        return yarnName;
    }

    public void setYarnName(String yarnName) {
        this.yarnName = yarnName;
    }

    public Short getCountSno() {
        return countSno;
    }

    public void setCountSno(Short countSno) {
        this.countSno = countSno;
    }

    public Short getUnitSno() {
        return unitSno;
    }

    public void setUnitSno(Short unitSno) {
        this.unitSno = unitSno;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
