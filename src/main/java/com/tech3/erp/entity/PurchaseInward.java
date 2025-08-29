package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "purchase_inward", schema = "masters")
public class PurchaseInward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inward_date", nullable = false)
    private LocalDateTime inwardDate = LocalDateTime.now();

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;
    
    @Column(name = "po_id")
    private Long poId;

    @OneToMany(mappedBy = "purchaseInward", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PurchaseInwardItem> items;


    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public LocalDateTime getInwardDate() {
        return inwardDate;
    }

    public void setInwardDate(LocalDateTime inwardDate) {
        this.inwardDate = inwardDate;
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

    public Long getPurchaseOrderId() {
        return poId;
    }

    public void setPurchaseOrderId(Long poId) {
        this.poId = poId;
    }

    public List<PurchaseInwardItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseInwardItem> items) {
        this.items = items;
        for (PurchaseInwardItem item : items) {
            item.setPurchaseInward(this);
        }
    }
}

