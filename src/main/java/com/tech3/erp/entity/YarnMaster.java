package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "yarn_master", schema = "masters")
public class YarnMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yarn_name", unique = true, nullable = false, length = 50)
    @NotBlank(message = "Yarn name is required")
    @Size(max = 50, message = "Yarn name must be up to 50 characters")
    private String yarnName;

    @Column(name = "count_sno", nullable = false)
    @NotNull(message = "Count SNO is required")
    private Short countSno;

    @Column(name = "unit_sno", nullable = false)
    private Short unitSno;

    @Column(name = "types", nullable = false, length = 50)
    @NotBlank(message = "Types are required")
    @Size(max = 50, message = "Types must be up to 50 characters")
    private String types;
    
    @Column(name = "content", nullable = false, length = 50)
    @Size(max = 50, message = "Content must be up to 50 characters")
    private String content;

    @Column(name = "conversion", nullable = false)
    @NotNull(message = "Conversion value is required")
    private Double conversion;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    // Default constructor
    public YarnMaster() {}

    // Constructor with parameters
    public YarnMaster(String yarnName, Short countSno, Short unitSno, String types, 
    		Double conversion, boolean activeFlag, String content) {
        this.yarnName = yarnName;
        this.countSno = countSno;
        this.unitSno = unitSno;
        this.types = types;
        this.conversion = conversion;
        this.activeFlag = activeFlag;
        this.content = content;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getYarnName() { return yarnName; }
    public void setYarnName(String yarnName) { this.yarnName = yarnName; }

    public Short getCountSno() { return countSno; }
    public void setCountSno(Short countSno) { this.countSno = countSno; }

    public Short getUnitSno() { return unitSno; }
    public void setUnitSno(Short unitSno) { this.unitSno = unitSno; }

    public String getTypes() { return types; }
    public void setTypes(String types) { this.types = types; }

    public Double getConversion() { return conversion; }
    public void setConversion(Double conversion) { this.conversion = conversion; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}