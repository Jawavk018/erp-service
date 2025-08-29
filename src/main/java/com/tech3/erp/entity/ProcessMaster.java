package com.tech3.erp.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "process_master", schema = "masters")
public class ProcessMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "process_name", nullable = false, length = 100)
    private String processName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

 // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
