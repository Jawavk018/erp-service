package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "knitted_fabric_master", schema = "masters")
public class KnittedFabricMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short fabricTypeId;
    private Short fabricCategoryId;
    private Long knittedFabricId;
    private String fabricCode;
    private String fabricName;    
    private BigDecimal gsm;
    private String width;
    private String composition;
    private String shrinkage ;
    private String remarks;
   

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Short getFabricType() { return fabricTypeId; }
    public void setFabricType(Short fabricType) { this.fabricTypeId = fabricType; }
    
    public Short getFabricCategoryId() { return fabricCategoryId; }
    public void setFabricCategoryId(Short fabricCategoryId) { this.fabricCategoryId = fabricCategoryId; }
    
    public Long getKnittedFabricId() { return knittedFabricId; }
    public void setKnittedFabricId(Long knittedFabricId) { this.knittedFabricId = knittedFabricId; }

    public String getFabricCode() { return fabricCode; }
    public void setFabricCode(String fabricCode) { this.fabricCode = fabricCode; }

    public String getFabricName() { return fabricName; }
    public void setFabricName(String fabricName) { this.fabricName = fabricName; }
   
    public BigDecimal getGsm() { return gsm; }
    public void setGsm(BigDecimal gsm) { this.gsm = gsm; }
    
    public String getWidth() { return width; }
    public void setWidth(String width) { this.width = width; }
    
    public String getComposition() { return composition; }
    public void setComposition(String composition) { this.composition = composition; }
    
    public String getShrinkage() { return shrinkage; }
    public void setShrinkage(String shrinkage) { this.shrinkage = shrinkage; }
    
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    
}
