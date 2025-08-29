package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sizing_quality_details", schema = "masters")
public class SizingQualityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quality;
    private Long yarnId;
    private Long sordEnds;
    private Long actualEnds;
    private Long parts;
    private Long endsPerPart;
    private Long wrapMeters;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizing_plan_id")
    private SizingPlan sizingPlan;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Long getYarnId() {
        return yarnId;
    }

    public void setYarnId(Long yarnId) {
        this.yarnId = yarnId;
    }

    public Long getSordEnds() {
        return sordEnds;
    }

    public void setSordEnds(Long sordEnds) {
        this.sordEnds = sordEnds;
    }

    public Long getActualEnds() {
        return actualEnds;
    }

    public void setActualEnds(Long actualEnds) {
        this.actualEnds = actualEnds;
    }

    public Long getParts() {
        return parts;
    }

    public void setParts(Long parts) {
        this.parts = parts;
    }

    public Long getEndsPerPart() {
        return endsPerPart;
    }

    public void setEndsPerPart(Long endsPerPart) {
        this.endsPerPart = endsPerPart;
    }

    public Long getWrapMeters() {
        return wrapMeters;
    }

    public void setWrapMeters(Long wrapMeters) {
        this.wrapMeters = wrapMeters;
    }

    public SizingPlan getSizingPlan() {
        return sizingPlan;
    }

    public void setSizingPlan(SizingPlan sizingPlan) {
        this.sizingPlan = sizingPlan;
    }
}
