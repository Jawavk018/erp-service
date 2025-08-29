package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.SubCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SubCategoryDTO {
    private Long id;
    private Long categorySno;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String categoryName;

    @NotBlank(message = "Sub-category name is required")
    @Size(min = 2, max = 100, message = "Sub-category name must be between 2 and 100 characters")
    private String subCategoryName;

    private boolean activeFlag;

    public SubCategoryDTO() {}

    public SubCategoryDTO(Long id, Long categorySno, String categoryName, String subCategoryName, boolean activeFlag) {
        this.id = id;
        this.categorySno = categorySno;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
        this.activeFlag = activeFlag;
    }

    public SubCategoryDTO(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.categorySno = subCategory.getCategory().getId();
        this.categoryName = subCategory.getCategory().getCategoryName(); // Fetch country name
        this.subCategoryName = subCategory.getSubCategoryName();
        this.activeFlag = subCategory.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCategorySno() { return categorySno; }
    public void setCategorySno(Long categorySno) { this.categorySno = categorySno; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getSubCategoryName() { return subCategoryName; }
    public void setSubCategoryName(String subCategoryName) { this.subCategoryName = subCategoryName; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
