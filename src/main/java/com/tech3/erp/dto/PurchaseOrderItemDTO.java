package com.tech3.erp.dto;

import com.tech3.erp.entity.PurchaseOrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseOrderItemDTO {

    private Long id;
    private Long productCategoryId;
    private BigDecimal quantity;
    private String unit;
    private BigDecimal price;
    private BigDecimal netAmount;
    private LocalDateTime deliveryDate;
    private String remarks;
    private Boolean activeFlag;

    public PurchaseOrderItemDTO() {}

    public PurchaseOrderItemDTO(Long id, Long productCategoryId, BigDecimal quantity, String unit,
                                BigDecimal price, BigDecimal netAmount, LocalDateTime deliveryDate,
                                String remarks, Boolean activeFlag) {
        this.id = id;
        this.productCategoryId = productCategoryId;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
        this.netAmount = netAmount;
        this.deliveryDate = deliveryDate;
        this.remarks = remarks;
        this.activeFlag = activeFlag;
    }

    public PurchaseOrderItemDTO(PurchaseOrderItem entity) {
        this.id = entity.getId();
        this.productCategoryId = entity.getProductCategoryId();
        this.quantity = entity.getQuantity();
        this.unit = entity.getUnit();
        this.price = entity.getPrice();
        this.netAmount = entity.getNetAmount();
        this.deliveryDate = entity.getDeliveryDate();
        this.remarks = entity.getRemarks();
        this.activeFlag = entity.getActiveFlag();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
