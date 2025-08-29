package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "beam_inward_beam_details", schema = "masters")
public class BeamInwardBeamDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long weavingContractId;
    private Long salesOrderId;
    private Long emptyBeamId;
    private Long wrapMeters;
    private Long shrinkage;
    private Long expectedFabricMeter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beam_inward_id")
    private BeamInward beamInward;

    // Getters and Setters

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

    public BeamInward getBeamInward() {
        return beamInward;
    }

    public void setBeamInward(BeamInward beamInward) {
        this.beamInward = beamInward;
    }
}
