package com.tech3.erp.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesOrderDTO {
	
    private Long id;
    private String salesOrderNo;
    private Date orderDate;
    private Long buyerCustomerId;
    private String buyerPoNo;
    private Long deliverToId;
    private Long currencyId;
    private Double exchangeRate;
    private Long modeOfShipmentId;
    private Long shipmentTermsId;
    private Long paymentTermsId;
    private Long termsConditionsId;
    private Boolean activeFlag;
    private String buyerCustomerName;
    private String internalOrderNo;
    private Short packingTypeId;

    private List<SalesOrderItemDTO> items;
    
    // Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    
    public String getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getBuyerCustomerId() {
        return buyerCustomerId;
    }

    public void setBuyerCustomerId(Long buyerCustomerId) {
        this.buyerCustomerId = buyerCustomerId;
    }

    public String getBuyerPoNo() {
        return buyerPoNo;
    }

    public void setBuyerPoNo(String buyerPoNo) {
        this.buyerPoNo = buyerPoNo;
    }

    public Long getDeliverToId() {
        return deliverToId;
    }

    public void setDeliverToId(Long deliverToId) {
        this.deliverToId = deliverToId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Long getModeOfShipmentId() {
        return modeOfShipmentId;
    }

    public void setModeOfShipmentId(Long modeOfShipmentId) {
        this.modeOfShipmentId = modeOfShipmentId;
    }

    public Long getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Long paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }
    
    public Long getShipmentTermsId() {
        return shipmentTermsId;
    }

    public void setShipmentTermsId(Long shipmentTermsId) {
        this.shipmentTermsId = shipmentTermsId;
    }

    public Long getTermsConditionsId() {
        return termsConditionsId;
    }

    public void setTermsConditionsId(Long termsConditionsId) {
        this.termsConditionsId = termsConditionsId;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
    public String getBuyerCustomerName() {
        return buyerCustomerName;
    }

    public void setBuyerCustomerName(String buyerCustomerName) {
        this.buyerCustomerName = buyerCustomerName;
    }
    
    public Short getPackingTypeId() {
        return packingTypeId;
    }

    public void setPackingTypeId(Short packingTypeId) {
        this.packingTypeId = packingTypeId;
    }

    public List<SalesOrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SalesOrderItemDTO> items) {
        this.items = items;
    }
    
    public String getInternalOrderNo() {
        return internalOrderNo;
    }

    public void setInternalOrderNo(String internalOrderNo) {
        this.internalOrderNo = internalOrderNo;
    }

}
