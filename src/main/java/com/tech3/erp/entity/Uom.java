package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "uom", schema = "masters")
public class Uom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uom_name", unique = true, nullable = false, length = 50)
    private String uomName;

    @Column(name = "uom_code", unique = true, nullable = false, length = 10)
    private String uomCode;

    @Column(name = "description")
    private String description;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUomName() { return uomName; }
    public void setUomName(String uomName) { this.uomName = uomName; }

    public String getUomCode() { return uomCode; }
    public void setUomCode(String uomCode) { this.uomCode = uomCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
     public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
