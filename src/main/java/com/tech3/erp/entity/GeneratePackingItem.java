package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "generate_packing_item", schema = "masters")
public class GeneratePackingItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generated_packing_id", nullable = false)
    private GeneratePacking generatePacking;
    
    @Column(name = "roll_no", length = 50)
    private String rollNo;
    
    @Column(name = "length")
    private Double length;
    
    @Column(name = "uom_id")
    private Long uomId;
    
    @Column(name = "pounds")
    private Double pounds;
    
    @Column(name = "lot_id")
    private Long lotId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneratePacking getGeneratePacking() {
        return generatePacking;
    }

    public void setGeneratePacking(GeneratePacking generatePacking) {
        this.generatePacking = generatePacking;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Double getPounds() {
        return pounds;
    }

    public void setPounds(Double pounds) {
        this.pounds = pounds;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }
}