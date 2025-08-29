package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "purchase_orders", schema = "masters")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poNo;
    private LocalDate poDate;
    private Boolean activeFlag;
    private Long vendorId;
    private Long poTypeId;
    private Long taxId;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> items = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (this.poNo == null || this.poNo.isEmpty()) {
            this.poNo = generatePoNo();
        }
    }

    private String generatePoNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "PO-" + datePart + "-" + randomNum;
    }

    public void addItem(PurchaseOrderItem item) {
        item.setPurchaseOrder(this); // 👈 This is the key
        this.items.add(item);
    }

    // Getters and Setters
    // (Add for all fields including poDate, activeFlag, vendorId etc.)
    
    public Long getId() {
        return id;
    }

     public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public LocalDate getPoDate() {
        return poDate;
    }

    public void setPoDate(LocalDate poDate) {
        this.poDate = poDate;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<PurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseOrderItem> items) {
        this.items = items;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getPoTypeId() {
        return poTypeId;
    }

    public void setPoTypeId(Long poTypeId) {
        this.poTypeId = poTypeId;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }
}

