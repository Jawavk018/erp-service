//package com.tech3.erp.dto;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.tech3.erp.entity.PoTypeMaster;
//import com.tech3.erp.entity.ProductCategory;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//
//public class ProductCategoryDTO {
//
//    private Long id;
//
//    @NotNull
//    private PoTypeMaster poTypeId;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private String poTypeName;
//
//    @NotBlank
//    private String productCategoryName;
//
//    @NotBlank
//    private String fabricCode;
//
//    private String fabricQuality;
//
//    private boolean activeFlag;
//
//    public ProductCategoryDTO() {}
//
//    public ProductCategoryDTO(ProductCategory productCategory) {
//        this.id = productCategory.getId();
//        this.poTypeId = productCategory.getPoTypeId();
//        this.productCategoryName = productCategory.getProductCategoryName();
//        this.fabricCode = productCategory.getFabricCode();
//        this.fabricQuality = productCategory.getFabricQuality();
//        this.activeFlag = productCategory.getActiveFlag();
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public @NotNull PoTypeMaster getPoTypeId() {
//        return poTypeId;
//    }
//
//    public void setPoTypeId(@NotNull PoTypeMaster poTypeId) {
//        this.poTypeId = poTypeId;
//    }
//
//    public String getProductCategoryName() {
//        return productCategoryName;
//    }
//
//    public void setProductCategoryName(String productCategoryName) {
//        this.productCategoryName = productCategoryName;
//    }
//
//    public String getFabricCode() {
//        return fabricCode;
//    }
//
//    public void setFabricCode(String fabricCode) {
//        this.fabricCode = fabricCode;
//    }
//
//    public String getFabricQuality() {
//        return fabricQuality;
//    }
//
//    public void setFabricQuality(String fabricQuality) {
//        this.fabricQuality = fabricQuality;
//    }
//
//    public boolean getActiveFlag() {
//        return activeFlag;
//    }
//
//    public void setActiveFlag(boolean activeFlag) {
//        this.activeFlag = activeFlag;
//    }
//
//}





package com.tech3.erp.dto;

import com.tech3.erp.entity.ProductCategory;

public class ProductCategoryDTO {

    private Long id;
    private String productCategoryName;
    private String fabricCode;
    private String fabricQuality;
    private Boolean activeFlag;
    private Short poTypeId;

    public ProductCategoryDTO() {}

    public ProductCategoryDTO(ProductCategory entity) {
        this.id = entity.getId();
        this.productCategoryName = entity.getProductCategoryName();
        this.fabricCode = entity.getFabricCode();
        this.fabricQuality = entity.getFabricQuality();
        this.activeFlag = entity.getActiveFlag();
        this.poTypeId = entity.getPoType().getId().shortValue(); // Assuming poType ID is Long
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductCategoryName() { return productCategoryName; }
    public void setProductCategoryName(String productCategoryName) { this.productCategoryName = productCategoryName; }

    public String getFabricCode() { return fabricCode; }
    public void setFabricCode(String fabricCode) { this.fabricCode = fabricCode; }

    public String getFabricQuality() { return fabricQuality; }
    public void setFabricQuality(String fabricQuality) { this.fabricQuality = fabricQuality; }

    public Boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(Boolean activeFlag) { this.activeFlag = activeFlag; }

    public Short getPoTypeId() { return poTypeId; }
    public void setPoTypeId(Short poTypeId) { this.poTypeId = poTypeId; }
}

