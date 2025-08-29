package com.tech3.erp.dto;

import com.tech3.erp.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDTO {
    private Long id;

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 100, message = "Category name must be between 2 and 100 characters")
    private String categoryName;

    private boolean activeFlag; // Matches active_flag in the database

    // Default constructor
    public CategoryDTO() {
    }

    // Constructor with parameters
    public CategoryDTO(Long id, String categoryName, boolean activeFlag) {
        this.id = id;
        this.categoryName = categoryName;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.activeFlag = category.getActiveFlag(); // Assuming a getter in Category entity
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
