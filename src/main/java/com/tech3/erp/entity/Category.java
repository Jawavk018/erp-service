package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "category", schema = "masters")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", unique = true, nullable = false, length = 100)
    @NotNull
    @Size(min = 2, max = 100)
    private String categoryName;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;  // Default value as per the DB schema

    // Default constructor
    public Category() {
    }

    // Constructor with parameters
    public Category(Long id, String categoryName, boolean activeFlag) {
        this.id = id;
        this.categoryName = categoryName;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
