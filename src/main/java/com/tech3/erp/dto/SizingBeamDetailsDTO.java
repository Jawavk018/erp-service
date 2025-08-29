package com.tech3.erp.dto;

public class SizingBeamDetailsDTO {
    private Long id;
    private Long sizingPlanId;
    private Long weavingContractId;
    private Long salesOrderId;
    private Long emptyBeamId;
    private Long wrapMeters;
    private Long shrinkage;
    private Long expectedFabricMeter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSizingPlanId() {
        return sizingPlanId;
    }

    public void setSizingPlanId(Long sizingPlanId) {
        this.sizingPlanId = sizingPlanId;
    }

    public Long getWeavingContractId() {
        return weavingContractId;
    }

    public void setWeavingContractId(Long weavingContractId) {
        this.weavingContractId = weavingContractId;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Long getEmptyBeamId() {
        return emptyBeamId;
    }

    public void setEmptyBeamId(Long emptyBeamId) {
        this.emptyBeamId = emptyBeamId;
    }

    public Long getWrapMeters() {
        return wrapMeters;
    }

    public void setWrapMeters(Long wrapMeters) {
        this.wrapMeters = wrapMeters;
    }

    public Long getShrinkage() {
        return shrinkage;
    }

    public void setShrinkage(Long shrinkage) {
        this.shrinkage = shrinkage;
    }

    public Long getExpectedFabricMeter() {
        return expectedFabricMeter;
    }

    public void setExpectedFabricMeter(Long expectedFabricMeter) {
        this.expectedFabricMeter = expectedFabricMeter;
    }
}
