package com.tech3.erp.dto;

public class GeneratePackingItemDTO {
    private Long id;
    private Long generatedPackingId;
    private String rollNo;
    private Double length;
    private Long uomId;
    private Double pounds;
    private Long lotId;

    // Constructors
    public GeneratePackingItemDTO() {
    }

    public GeneratePackingItemDTO(Long id, Long generatedPackingId, String rollNo, 
                                Double length, Long uomId, Double pounds, Long lotId) {
        this.id = id;
        this.generatedPackingId = generatedPackingId;
        this.rollNo = rollNo;
        this.length = length;
        this.uomId = uomId;
        this.pounds = pounds;
        this.lotId = lotId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeneratedPackingId() {
        return generatedPackingId;
    }

    public void setGeneratedPackingId(Long generatedPackingId) {
        this.generatedPackingId = generatedPackingId;
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