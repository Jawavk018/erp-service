package com.tech3.erp.dto;

import lombok.Data;

@Data
public class FinishFabricReceiveItemDTO {
    private Long id;
    private String finishedFabricCode;
    private String rollNo;
    private String rollYards;
    private String weight;
    private Long gradeId;
    private Long warehouseId;
    private Boolean activeFlag;
    
 // Getters
    public Long getId() {
        return id;
    }

    public String getFinishedFabricCode() {
        return finishedFabricCode;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getRollYards() {
        return rollYards;
    }

    public String getWeight() {
        return weight;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFinishedFabricCode(String finishedFabricCode) {
        this.finishedFabricCode = finishedFabricCode;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setRollYards(String rollYards) {
        this.rollYards = rollYards;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}