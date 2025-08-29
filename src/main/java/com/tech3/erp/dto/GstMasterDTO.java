package com.tech3.erp.dto;

import com.tech3.erp.entity.GstMaster;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GstMasterDTO {
    private Long id;

    @NotBlank(message = "Gst name is required")
    @Size(min = 1, max = 50, message = "Gst name must be between 3 and 100 characters")
    private String gstName;
    private String cgstRate;
    private String sgstRate;
    private String igstRate;
    private String description;
    private boolean activeFlag;

    public GstMasterDTO() {}

    public GstMasterDTO(Long id, String gstName, String cgstRate, String sgstRate, String igstRate, String description, boolean activeFlag) {
        this.id = id;
        this.gstName = gstName;
        this.cgstRate = cgstRate;
        this.sgstRate = sgstRate;
        this.igstRate = igstRate;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public GstMasterDTO(GstMaster gstMaster) {
        this.id = gstMaster.getId();
        this.gstName = gstMaster.getGstName();
        this.cgstRate = gstMaster.getCGstRate();
        this.sgstRate = gstMaster.getSGstRate();
        this.igstRate = gstMaster.getIGstRate();
        this.description = gstMaster.getDescription();
        this.activeFlag = gstMaster.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGstName() { return gstName; }
    public void setGstName(String gstName) { this.gstName = gstName; }

    public String getCGstRate() { return cgstRate; }
    public void setCGstRate(String cgstRate) { this.cgstRate = cgstRate; }

    public String getSGstRate() { return sgstRate; }
    public void setSGstRate(String sgstRate) { this.sgstRate = sgstRate; }

    public String getIGstRate() { return igstRate; }
    public void setIGstRate(String igstRate) { this.igstRate = igstRate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}