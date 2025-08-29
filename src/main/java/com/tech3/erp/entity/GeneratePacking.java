package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "generate_packing", schema = "masters")
public class GeneratePacking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "packing_date")
    private Date packingDate;
    
    @Column(name = "buyer_id")
    private Long buyerId;
    
    @Column(name = "sales_order_id")
    private Long salesOrderId;
    
    @Column(name = "warehouse_id")
    private Long warehouseId;
    
    @Column(name = "tare_weight", length = 50)
    private String tareWeight;
    
    @Column(name = "gross_weight", length = 50)
    private String grossWeight;
    
    @Column(name = "packing_slip_no", length = 255)
    private String packingSlipNo;
    
    @OneToMany(mappedBy = "generatePacking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneratePackingItem> items = new ArrayList<>();

    
    @PrePersist
    public void prePersist() {
        if (this.packingSlipNo == null || this.packingSlipNo.isEmpty()) {
            this.packingSlipNo = generatePackingSlipNo();
        }
    }

    private String generatePackingSlipNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "PSNO-" + datePart + "-" + randomNum;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPackingDate() {
        return packingDate;
    }

    public void setPackingDate(Date packingDate) {
        this.packingDate = packingDate;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(String tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getPackingSlipNo() {
        return packingSlipNo;
    }

    public void setPackingSlipNo(String packingSlipNo) {
        this.packingSlipNo = packingSlipNo;
    }

    public List<GeneratePackingItem> getItems() {
        return items;
    }

    public void setItems(List<GeneratePackingItem> items) {
        this.items = items;
    }
}
