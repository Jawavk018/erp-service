package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "woven_fabric_master", schema = "masters")
public class WovenFabricMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short fabricTypeId;
    private Short fabricCategoryId;
    private Long wovenFabricId;
    private String fabricCode;
    private String fabricName;
    private String content;
    private Short weave;
    private String fabricQuality;
    private String uom;
    private Integer epi;
    private Integer ppi;
    private String greigeCode;
    private Integer totalEnds;
    private BigDecimal gsm;
    private BigDecimal glm;
    private BigDecimal igst;
    private BigDecimal cgst;
    private BigDecimal sgst;
    private BigDecimal stdValue;
    private String fabricImageUrl;  
    
    @OneToMany(mappedBy = "wovenFabricMaster", cascade = CascadeType.ALL)
    private List<FabricWarpDetail> warpDetails;
    
    @OneToMany(mappedBy = "wovenFabricMaster", cascade = CascadeType.ALL)
    private List<FabricWeftDetail> weftDetails;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fabric_type", insertable = false, updatable = false)
//    private FabricType fabricTypeEntity;


    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Short getFabricType() { return fabricTypeId; }
    public void setFabricType(Short fabricType) { this.fabricTypeId = fabricType; }
    
    public Short getFabricCategoryId() { return fabricCategoryId; }
    public void setFabricCategoryId(Short fabricCategoryId) { this.fabricCategoryId = fabricCategoryId; }
    
    public Long getWovenFabricId() { return wovenFabricId; }
    public void setWovenFabricId(Long wovenFabricId) { this.wovenFabricId = wovenFabricId; }

    public String getFabricCode() { return fabricCode; }
    public void setFabricCode(String fabricCode) { this.fabricCode = fabricCode; }

    public String getFabricName() { return fabricName; }
    public void setFabricName(String fabricName) { this.fabricName = fabricName; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Short getWeave() { return weave; }
    public void setWeave(Short weave) { this.weave = weave; }

    public String getFabricQuality() { return fabricQuality; }
    public void setFabricQuality(String fabricQuality) { this.fabricQuality = fabricQuality; }

    public String getUom() { return uom; }
    public void setUom(String uom) { this.uom = uom; }

    public Integer getEpi() { return epi; }
    public void setEpi(Integer epi) { this.epi = epi; }

    public Integer getPpi() { return ppi; }
    public void setPpi(Integer ppi) { this.ppi = ppi; }

    public String getGreigeCode() { return greigeCode; }
    public void setGreigeCode(String greigeCode) { this.greigeCode = greigeCode; }

    public Integer getTotalEnds() { return totalEnds; }
    public void setTotalEnds(Integer totalEnds) { this.totalEnds = totalEnds; }

    public BigDecimal getGsm() { return gsm; }
    public void setGsm(BigDecimal gsm) { this.gsm = gsm; }

    public BigDecimal getGlm() { return glm; }
    public void setGlm(BigDecimal glm) { this.glm = glm; }

    public BigDecimal getIgst() { return igst; }
    public void setIgst(BigDecimal igst) { this.igst = igst; }

    public BigDecimal getCgst() { return cgst; }
    public void setCgst(BigDecimal cgst) { this.cgst = cgst; }

    public BigDecimal getSgst() { return sgst; }
    public void setSgst(BigDecimal sgst) { this.sgst = sgst; }
    
    public BigDecimal getStdValue() {
        return stdValue;
    }

    public void setStdValue(BigDecimal stdValue) {
        this.stdValue = stdValue;
    }

    public String getFabricImageUrl() { return fabricImageUrl; }
    public void setFabricImageUrl(String fabricImageUrl) { this.fabricImageUrl = fabricImageUrl; }

    public List<FabricWarpDetail> getWarpDetails() { return warpDetails; }
    public void setWarpDetails(List<FabricWarpDetail> warpDetails) { this.warpDetails = warpDetails; }

    public List<FabricWeftDetail> getWeftDetails() { return weftDetails; }
    public void setWeftDetails(List<FabricWeftDetail> weftDetails) { this.weftDetails = weftDetails; }
    
//    public FabricType getFabricTypeEntity() {
//        return fabricTypeEntity;
//    }
//
//    public void setFabricTypeEntity(FabricType fabricTypeEntity) {
//        this.fabricTypeEntity = fabricTypeEntity;
//    }
}
