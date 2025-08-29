package com.tech3.erp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GenerateInvoiceDTO {
    private Long id;
    private Long manufactureId;
    private LocalDate invoiceDate;
    private String invoiceNo;
    private Long salesOrderId;
    private Long companyBankId;
    private Long termsConditionsId;
    private Long paymentTermsId;
    private Long shipToId;
    private Long shipmentMode;
    private Long customerId;
    private Long consgineeId;
    private BigDecimal taxAmount;
    private BigDecimal totalAmount;
    private String comments;
    private Boolean activeFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(Long manufactureId) {
        this.manufactureId = manufactureId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Long getCompanyBankId() {
        return companyBankId;
    }

    public void setCompanyBankId(Long companyBankId) {
        this.companyBankId = companyBankId;
    }

    public Long getTermsConditionsId() {
        return termsConditionsId;
    }

    public void setTermsConditionsId(Long termsConditionsId) {
        this.termsConditionsId = termsConditionsId;
    }

    public Long getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Long paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public Long getShipToId() {
        return shipToId;
    }

    public void setShipToId(Long shipToId) {
        this.shipToId = shipToId;
    }

    public Long getShipmentMode() {
        return shipmentMode;
    }

    public void setShipmentMode(Long shipmentMode) {
        this.shipmentMode = shipmentMode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getConsgineeId() {
        return consgineeId;
    }

    public void setConsgineeId(Long consgineeId) {
        this.consgineeId = consgineeId;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
