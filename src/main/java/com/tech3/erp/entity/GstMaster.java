package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gst_master", schema = "masters")
public class GstMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gst_name", unique = true, nullable = false, length = 100)
    private String gstName;

    @Column(name = "cgst_rate")
    private String cgstRate;

     @Column(name = "sgst_rate")
    private String sgstRate;

     @Column(name = "igst_rate")
    private String igstRate;

    @Column(name = "description")
    private String description;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

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
