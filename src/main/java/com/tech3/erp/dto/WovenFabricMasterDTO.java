package com.tech3.erp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.tech3.erp.entity.WovenFabricMaster;
import com.tech3.erp.entity.FabricType;
import com.tech3.erp.entity.FabricWarpDetail;
import com.tech3.erp.entity.FabricWeftDetail;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

public class WovenFabricMasterDTO implements Serializable {

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
    
    @Transient
    private String fabricTypeName;

    private List<FabricWarpDetailDTO> warpDetails;
    private List<FabricWeftDetailDTO> weftDetails;
    
    // Default Constructor
    public WovenFabricMasterDTO() {}

    // Constructor using FabricMaster entity
    public WovenFabricMasterDTO(WovenFabricMaster entity) {
        this.id = entity.getId();
        this.fabricTypeId = entity.getFabricType();
        this.fabricCategoryId = entity.getFabricCategoryId();
        this.wovenFabricId = entity.getWovenFabricId();
        this.fabricCode = entity.getFabricCode();
        this.fabricName = entity.getFabricName();
        this.weave = entity.getWeave();
        this.fabricQuality = entity.getFabricQuality();
        this.uom = entity.getUom();
        this.epi = entity.getEpi();
        this.ppi = entity.getPpi();
        this.greigeCode = entity.getGreigeCode();
        this.totalEnds = entity.getTotalEnds();
        this.gsm = entity.getGsm();
        this.glm = entity.getGlm();
        this.igst = entity.getIgst();
        this.cgst = entity.getCgst();
        this.sgst = entity.getSgst();
        this.stdValue = entity.getStdValue();
        this.fabricImageUrl = entity.getFabricImageUrl();

        // Convert Warp and Weft detail entities to DTOs
        if (entity.getWarpDetails() != null) {
            this.warpDetails = entity.getWarpDetails().stream()
                .map(FabricWarpDetailDTO::new)
                .collect(Collectors.toList());
        }

        if (entity.getWeftDetails() != null) {
            this.weftDetails = entity.getWeftDetails().stream()
                .map(FabricWeftDetailDTO::new)
                .collect(Collectors.toList());
        }
        
//        if (entity.getFabricTypeEntity() != null) {
//            this.fabricTypeName = entity.getFabricTypeEntity().getFabricTypeName();
//        }
        

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getFabricType() {
        return fabricTypeId;
    }
    
    public void setFabricType(Short fabricType) {
        this.fabricTypeId = fabricType;
    }
    
    public Short getFabricCategoryId() {
        return fabricCategoryId;
    }
    
    public void setFabricCategoryId(Short fabricCategoryId) {
        this.fabricCategoryId = fabricCategoryId;
    }

    public void setWovenFabricId(Long wovenFabricId) {
        this.wovenFabricId = wovenFabricId;
    }
    
    public Long getWovenFabricId() {
        return wovenFabricId;
    }

    public String getFabricCode() {
        return fabricCode;
    }

    public void setFabricCode(String fabricCode) {
        this.fabricCode = fabricCode;
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getWeave() {
        return weave;
    }

    public void setWeave(Short weave) {
        this.weave = weave;
    }

    public String getFabricQuality() {
        return fabricQuality;
    }

    public void setFabricQuality(String fabricQuality) {
        this.fabricQuality = fabricQuality;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Integer getEpi() {
        return epi;
    }

    public void setEpi(Integer epi) {
        this.epi = epi;
    }

    public Integer getPpi() {
        return ppi;
    }

    public void setPpi(Integer ppi) {
        this.ppi = ppi;
    }

    public String getGreigeCode() {
        return greigeCode;
    }

    public void setGreigeCode(String greigeCode) {
        this.greigeCode = greigeCode;
    }

    public Integer getTotalEnds() {
        return totalEnds;
    }

    public void setTotalEnds(Integer totalEnds) {
        this.totalEnds = totalEnds;
    }

    public BigDecimal getGsm() {
        return gsm;
    }

    public void setGsm(BigDecimal gsm) {
        this.gsm = gsm;
    }

    public BigDecimal getGlm() {
        return glm;
    }

    public void setGlm(BigDecimal glm) {
        this.glm = glm;
    }

    public BigDecimal getIgst() {
        return igst;
    }

    public void setIgst(BigDecimal igst) {
        this.igst = igst;
    }

    public BigDecimal getCgst() {
        return cgst;
    }

    public void setCgst(BigDecimal cgst) {
        this.cgst = cgst;
    }

    public BigDecimal getSgst() {
        return sgst;
    }

    public void setSgst(BigDecimal sgst) {
        this.sgst = sgst;
    }
    
    public BigDecimal getStdValue() {
        return stdValue;
    }

    public void setStdValue(BigDecimal stdValue) {
        this.stdValue = stdValue;
    }

    public String getFabricImageUrl() {
        return fabricImageUrl;
    }

    public void setFabricImageUrl(String fabricImageUrl) {
        this.fabricImageUrl = fabricImageUrl;
    }

    public List<FabricWarpDetailDTO> getWarpDetails() {
        return warpDetails;
    }

    public void setWarpDetails(List<FabricWarpDetailDTO> warpDetails) {
        this.warpDetails = warpDetails;
    }

    public List<FabricWeftDetailDTO> getWeftDetails() {
        return weftDetails;
    }

    public void setWeftDetails(List<FabricWeftDetailDTO> weftDetails) {
        this.weftDetails = weftDetails;
    }
    
    public String getFabricTypeName() {
        return fabricTypeName;
    }

    public void setFabricTypeName(String fabricTypeName) {
        this.fabricTypeName = fabricTypeName;
    }
   
}

