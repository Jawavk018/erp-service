package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "dyeing_work_order", schema = "masters")
public class DyeingWorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dyeingWorkOrderNo;

    private LocalDate processContactDate;
    private LocalDate deliveryDate;
    private Long vendorId;
    private Long salesOrderNo;
    private Long consigneeId;
    private Long lapDipStatusId;
    private Long firstYardageId;
    private Double totalAmount;
    private Boolean activeFlag = true;

    @Column(columnDefinition = "text")
    private String remarks;

    

    @OneToMany(mappedBy = "dyeingWorkOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DyeingWorkOrderItem> items = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (this.dyeingWorkOrderNo == null || this.dyeingWorkOrderNo.isEmpty()) {
            this.dyeingWorkOrderNo = generateDyeingWorkOrderNo();
        }
    }

    private String generateDyeingWorkOrderNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "DWO-" + datePart + "-" + randomNum;
    }

    // Getters and Setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDyeingWorkOrderNo() {
        return dyeingWorkOrderNo;
    }
    public void setDyeingWorkOrderNo(String dyeingWorkOrderNo) {
        this.dyeingWorkOrderNo = dyeingWorkOrderNo;
    }

    public LocalDate getProcessContactDate() {
        return processContactDate;
    }
    public void setProcessContactDate(LocalDate processContactDate) {
        this.processContactDate = processContactDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getVendorId() {
        return vendorId;
    }
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getSalesOrderNo() {
        return salesOrderNo;
    }
    public void setSalesOrderNo(Long salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public Long getConsigneeId() {
        return consigneeId;
    }
    public void setConsigneeId(Long consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Long getLapDipStatusId() {
        return lapDipStatusId;
    }
    public void setLapDipStatusId(Long lapDipStatusId) {
        this.lapDipStatusId = lapDipStatusId;
    }

    public Long getFirstYardageId() {
        return firstYardageId;
    }
    public void setFirstYardageId(Long firstYardageId) {
        this.firstYardageId = firstYardageId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
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

    public List<DyeingWorkOrderItem> getItems() {
        return items;
    }
    public void setItems(List<DyeingWorkOrderItem> items) {
        this.items = items;
    }

}
