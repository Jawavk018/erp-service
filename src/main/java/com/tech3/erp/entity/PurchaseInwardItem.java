package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "purchase_inward_item", schema = "masters")
public class PurchaseInwardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity_received", nullable = false)
    private BigDecimal quantityReceived;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "active_flag", nullable = false)
    private Boolean activeFlag;

//    @ManyToOne
//    @JoinColumn(name = "inward_id", nullable = false)
//    private PurchaseInward purchaseInward;
    @ManyToOne
    @JoinColumn(name = "inward_id")
    @JsonBackReference
    private PurchaseInward purchaseInward;

    @Column(name = "po_item_id", nullable = false)
    private Long purchaseOrderItemId;

//    @OneToMany(mappedBy = "purchaseInwardItem", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<LotEntry> lotEntries;
    @OneToMany(mappedBy = "purchaseInwardItem", cascade = CascadeType.ALL)
    @JsonManagedReference
    
    private List<LotEntry> lotEntries;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public BigDecimal getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(BigDecimal quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public PurchaseInward getPurchaseInward() {
        return purchaseInward;
    }

    public void setPurchaseInward(PurchaseInward purchaseInward) {
        this.purchaseInward = purchaseInward;
    }

    public Long getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    public void setPurchaseOrderItemId(Long purchaseOrderItemId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
    }

    public List<LotEntry> getLotEntries() {
        return lotEntries;
    }

    public void setLotEntries(List<LotEntry> lotEntries) {
        this.lotEntries = lotEntries;
    }

}

