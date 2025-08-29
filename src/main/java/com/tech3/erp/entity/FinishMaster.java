package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "finish_master", schema = "masters")
public class FinishMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "finish_name", unique = true, nullable = false, length = 50)
    private String finishName;

    @Column(name = "finish_code", unique = true, nullable = false, length = 10)
    private String finishCode;

    @Column(name = "description")
    private String description;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFinishName() { return finishName; }
    public void setFinishName(String finishName) { this.finishName = finishName; }

    public String getFinishCode() { return finishCode; }
    public void setFinishCode(String finishCode) { this.finishCode = finishCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
     public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
