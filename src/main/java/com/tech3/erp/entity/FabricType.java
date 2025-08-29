package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "fabric_type", schema = "masters")
public class FabricType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fabric_type_name", unique = true, nullable = false, length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private String fabricTypeName;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;  // Default value as per the DB schema

    // Default constructor
    public FabricType() {
    }

    // Constructor with parameters
    public FabricType(Long id, String fabricTypeName, boolean activeFlag) {
        this.id = id;
        this.fabricTypeName = fabricTypeName;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricTypeName() {
        return fabricTypeName;
    }

    public void setFabricTypeName(String fabricTypeName) {
        this.fabricTypeName = fabricTypeName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
