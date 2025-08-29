package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "jobwork_fabric_receive_item", schema = "masters")
public class JobworkFabricReceiveItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity_received", nullable = false)
    private BigDecimal quantityReceived;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "active_flag", nullable = false)
    private Boolean activeFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobwork_fabric_receive_id", nullable = false)
    @JsonBackReference
    private JobworkFabricReceive jobworkFabricReceive;


    @Column(name = "weaving_contract_item_id", nullable = false)
    private Long weavingContractItemId;

    @OneToMany(mappedBy = "jobworkFabricReceiveItem", cascade = CascadeType.ALL)
    @JsonManagedReference
    
    private List<PieceEntry> pieceEntries;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public JobworkFabricReceive getJobworkFabricReceive() {
        return jobworkFabricReceive;
    }

    public void setJobworkFabricReceive(JobworkFabricReceive jobworkFabricReceive) {
        this.jobworkFabricReceive = jobworkFabricReceive;
    }

    public Long getWeavingContractItemId() {
        return weavingContractItemId;
    }

    public void setWeavingContractItemId(Long weavingContractItemId) {
        this.weavingContractItemId = weavingContractItemId;
    }

    public List<PieceEntry> getPieceEntries() {
        return pieceEntries;
    }

    public void setPieceEntries(List<PieceEntry> pieceEntries) {
        this.pieceEntries = pieceEntries;
    }
    
}


