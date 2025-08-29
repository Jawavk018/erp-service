package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_category", schema = "masters")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "po_type_id", nullable = false)
    private PoTypeMaster poTypeId;

    @Column(name = "product_category_name", nullable = false, length = 150)
    private String productCategoryName;

    @Column(name = "fabric_code", nullable = false, length = 50, unique = true)
    private String fabricCode;

    @Column(name = "fabric_quality", length = 150)
    private String fabricQuality;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PoTypeMaster getPoType() {
        return poTypeId;
    }

    public void setPoType(PoTypeMaster poTypeId) {
        this.poTypeId = poTypeId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getFabricCode() {
        return fabricCode;
    }

    public void setFabricCode(String fabricCode) {
        this.fabricCode = fabricCode;
    }

    public String getFabricQuality() {
        return fabricQuality;
    }

    public void setFabricQuality(String fabricQuality) {
        this.fabricQuality = fabricQuality;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
