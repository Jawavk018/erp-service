package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sales_order_item", schema = "masters")
public class SalesOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sales_order_id", nullable = false)
    @JsonBackReference
    private SalesOrder salesOrder;

    private Long fabricTypeId;
    private String quality;
    private String buyerProduct;
    private Integer orderQty;
    private Double pricePerUnit;
    private Long uomId;
    private Double totalAmount;
    private Double gstPercent;
    private Double gstAmount;
    private Double finalAmount;
    private Date deliveryDate;
    private String remarks;
    private Short fabricMasterTypeId;
    private Short fabricCategoryId;
    private Long fabricMasterId;
    private Boolean activeFlag;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Long getFabricTypeId() {
        return fabricTypeId;
    }

    public void setFabricTypeId(Long fabricTypeId) {
        this.fabricTypeId = fabricTypeId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getBuyerProduct() {
        return buyerProduct;
    }

    public void setBuyerProduct(String buyerProduct) {
        this.buyerProduct = buyerProduct;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getGstPercent() {
        return gstPercent;
    }

    public void setGstPercent(Double gstPercent) {
        this.gstPercent = gstPercent;
    }

    public Double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(Double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public Short getFabricMasterTypeId() { 
    	return fabricMasterTypeId; 
    }
    
    public void setFabricMasterTypeId(Short fabricMasterTypeId) { 
    	this.fabricMasterTypeId = fabricMasterTypeId; 
    }
    
    public Short getFabricCategoryId() { 
    	return fabricCategoryId; 
    }
    
    public void setFabricCategoryId(Short fabricCategoryId) { 
    	this.fabricCategoryId = fabricCategoryId; 
    }
    
    public Long getFabricMasterId() { 
    	return fabricMasterId; 
    }
    
    public void setFabricMasterId(Long fabricMasterId) { 
    	this.fabricMasterId = fabricMasterId; 
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

}
