package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "flange_master", schema = "masters")
public class Flange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flange_no", unique = true, nullable = false, length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private String flangeNo;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;  // Default value as per the DB schema

    // Default constructor
    public Flange() {
    }

    // Constructor with parameters
    public Flange(Long id, String flangeNo, boolean activeFlag) {
        this.id = id;
        this.flangeNo = flangeNo;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlangeNo() {
        return flangeNo;
    }

    public void setFlangeNo(String flangeNo) {
        this.flangeNo = flangeNo;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}


