package com.tech3.erp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "generate_invoice", schema = "masters")

public class GenerateInvoice {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "manufacture_id")
	    private Long manufactureId;

	    @Column(name = "invoice_date")
	    private LocalDate invoiceDate;

	    @Column(name = "invoice_no", length = 100)
	    private String invoiceNo;

	    @Column(name = "sales_order_id")
	    private Long salesOrderId;

	    @Column(name = "company_bank_id")
	    private Long companyBankId;

	    @Column(name = "terms_conditions_id")
	    private Long termsConditionsId;

	    @Column(name = "payment_terms_id")
	    private Long paymentTermsId;

	    @Column(name = "ship_to_id")
	    private Long shipToId;

	    @Column(name = "shipment_mode")
	    private Long shipmentMode;

	    @Column(name = "customer_id")
	    private Long customerId;

	    @Column(name = "consginee_id")
	    private Long consgineeId;

	    @Column(name = "tax_amount")
	    private BigDecimal taxAmount;

	    @Column(name = "total_amount")
	    private BigDecimal totalAmount;

	    @Column(name = "comments", columnDefinition = "text")
	    private String comments;

	    @Column(name = "active_flag")
	    private Boolean activeFlag = true;

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
