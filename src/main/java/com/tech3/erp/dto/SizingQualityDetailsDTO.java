package com.tech3.erp.dto;

public class SizingQualityDetailsDTO {
	
    private Long id;
    private Long sizingPlanId;
    private String quality;
    private Long yarnId;
    private Long sordEnds;
    private Long actualEnds;
    private Long parts;
    private Long endsPerPart;
    private Long wrapMeters;

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
}

