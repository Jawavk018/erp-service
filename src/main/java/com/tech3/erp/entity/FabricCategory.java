package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "fabric_category", schema = "masters")
public class FabricCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fabric_category_name", nullable = false, length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private String fabricCategoryName;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;  // Default value as per the DB schema

    // Default constructor
    public FabricCategory() {
    }

    // Constructor with parameters
    public FabricCategory(Long id, String fabricCategoryName, boolean activeFlag) {
        this.id = id;
        this.fabricCategoryName = fabricCategoryName;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricCategoryName() {
        return fabricCategoryName;
    }

    public void setFabricCategoryName(String fabricCategoryName) {
        this.fabricCategoryName = fabricCategoryName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
