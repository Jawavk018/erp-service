//package com.tech3.erp.dto;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//public class FabricWeftDetailDTO implements Serializable {
//    private Long id;
//    private Long yarnId;
//    private Short color;
//    private BigDecimal shrinkagePercent;
//    private BigDecimal gramsPerMeter;
//
//    public FabricWeftDetailDTO() {}
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getYarnId() {
//        return yarnId;
//    }
//
//    public void setYarnId(Long yarnId) {
//        this.yarnId = yarnId;
//    }
//
//    public Short getColor() {
//        return color;
//    }
//
//    public void setColor(Short color) {
//        this.color = color;
//    }
//
//    public BigDecimal getShrinkagePercent() {
//        return shrinkagePercent;
//    }
//
//    public void setShrinkagePercent(BigDecimal shrinkagePercent) {
//        this.shrinkagePercent = shrinkagePercent;
//    }
//
//    public BigDecimal getGramsPerMeter() {
//        return gramsPerMeter;
//    }
//
//    public void setGramsPerMeter(BigDecimal gramsPerMeter) {
//        this.gramsPerMeter = gramsPerMeter;
//    }
//}



package com.tech3.erp.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.tech3.erp.entity.FabricWeftDetail;

public class FabricWeftDetailDTO implements Serializable {
    private Long id;
    private Long yarnId;
    private Short color;
    private BigDecimal shrinkagePercent;
    private BigDecimal gramsPerMeter;

    // Default constructor
    public FabricWeftDetailDTO() {}

    // Constructor using entity
    public FabricWeftDetailDTO(FabricWeftDetail entity) {
        this.id = entity.getId();
        this.yarnId = entity.getYarnId();
        this.color = entity.getColor();
        this.shrinkagePercent = entity.getShrinkagePercent();
        this.gramsPerMeter = entity.getGramsPerMeter();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYarnId() {
        return yarnId;
    }

    public void setYarnId(Long yarnId) {
        this.yarnId = yarnId;
    }

    public Short getColor() {
        return color;
    }

    public void setColor(Short color) {
        this.color = color;
    }

    public BigDecimal getShrinkagePercent() {
        return shrinkagePercent;
    }

    public void setShrinkagePercent(BigDecimal shrinkagePercent) {
        this.shrinkagePercent = shrinkagePercent;
    }

    public BigDecimal getGramsPerMeter() {
        return gramsPerMeter;
    }

    public void setGramsPerMeter(BigDecimal gramsPerMeter) {
        this.gramsPerMeter = gramsPerMeter;
    }
}

