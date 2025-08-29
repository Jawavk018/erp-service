package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "lot_outward", schema = "masters")
public class LotOutward {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "lot_entry_id", nullable = false)
    private Long lotEntryId;
    
    @Column(name = "outward_type", nullable = false, length = 50)
    private String outwardType;
    
    @Column(name = "reference_id")
    private Long referenceId;
    
    @Column(name = "reference_type", length = 50)
    private String referenceType;
    
    @Column(name = "quantity", nullable = false, precision = 38, scale = 2)
    private BigDecimal quantity;
    
    @Column(name = "outward_date", nullable = false)
    private LocalDate outwardDate;
    
    @Column(name = "remarks")
    private String remarks;
    
    @Column(name = "created_by", length = 100)
    private String createdBy;
    
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLotEntryId() {
        return lotEntryId;
    }

    public void setLotEntryId(Long lotEntryId) {
        this.lotEntryId = lotEntryId;
    }

    public String getOutwardType() {
        return outwardType;
    }

    public void setOutwardType(String outwardType) {
        this.outwardType = outwardType;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOutwardDate() {
        return outwardDate;
    }

    public void setOutwardDate(LocalDate outwardDate) {
        this.outwardDate = outwardDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "LotOutward{" +
                "id=" + id +
                ", lotEntryId=" + lotEntryId +
                ", outwardType='" + outwardType + '\'' +
                ", referenceId=" + referenceId +
                ", referenceType='" + referenceType + '\'' +
                ", quantity=" + quantity +
                ", outwardDate=" + outwardDate +
                ", remarks='" + remarks + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", activeFlag=" + activeFlag +
                '}';
    }
}