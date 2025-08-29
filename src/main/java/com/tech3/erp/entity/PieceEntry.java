package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "piece_entry", schema = "masters")
public class PieceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "piece_number", length = 100)
    private String pieceNumber;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;
    
    @ManyToOne
    @JoinColumn(name = "jobwork_fabric_receive_item_id")
    @JsonBackReference
    private JobworkFabricReceiveItem jobworkFabricReceiveItem;
    
    @PrePersist
    public void prePersist() {
        if (this.pieceNumber == null || this.pieceNumber.isEmpty()) {
            this.pieceNumber = generatePieceNumber();
        }
    }

    private String generatePieceNumber() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "PNO-" + datePart + "-" + randomNum;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(String pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

    public JobworkFabricReceiveItem getJobworkFabricReceiveItem() {
        return jobworkFabricReceiveItem;
    }

    public void setJobworkFabricReceiveItem(JobworkFabricReceiveItem jobworkFabricReceiveItem) {
        this.jobworkFabricReceiveItem = jobworkFabricReceiveItem;
    }
}

