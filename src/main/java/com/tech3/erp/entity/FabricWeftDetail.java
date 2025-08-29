package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

import com.tech3.erp.dto.FabricWeftDetailDTO;

@Entity
@Table(name = "fabric_weft_detail", schema = "masters")
public class FabricWeftDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long yarnId;
    private Short color;
    private BigDecimal shrinkagePercent;
    private BigDecimal gramsPerMeter;

    @ManyToOne
    @JoinColumn(name = "fabric_id", nullable = false)
    private WovenFabricMaster wovenFabricMaster;

    public FabricWeftDetail() {}
    
    public FabricWeftDetail(FabricWeftDetailDTO dto) {
        this.yarnId = dto.getYarnId();
        this.color = dto.getColor();
        this.shrinkagePercent = dto.getShrinkagePercent();
        this.gramsPerMeter = dto.getGramsPerMeter();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getYarnId() { return yarnId; }
    public void setYarnId(Long yarnId) { this.yarnId = yarnId; }

    public Short getColor() { return color; }
    public void setColor(Short color) { this.color = color; }

    public BigDecimal getShrinkagePercent() { return shrinkagePercent; }
    public void setShrinkagePercent(BigDecimal shrinkagePercent) { this.shrinkagePercent = shrinkagePercent; }

    public BigDecimal getGramsPerMeter() { return gramsPerMeter; }
    public void setGramsPerMeter(BigDecimal gramsPerMeter) { this.gramsPerMeter = gramsPerMeter; }

    public WovenFabricMaster getFabricMaster() { return wovenFabricMaster; }
    public void setFabricMaster(WovenFabricMaster wovenFabricMaster) { this.wovenFabricMaster = wovenFabricMaster; }
}
