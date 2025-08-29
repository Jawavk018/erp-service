package com.tech3.erp.dto;

import com.tech3.erp.entity.DyeingWorkOrder;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DyeingWorkOrderDTO {

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
    private String remarks;
    private Boolean activeFlag;
    private List<DyeingWorkOrderItemDTO> items;

    public DyeingWorkOrderDTO() {}

    public DyeingWorkOrderDTO(DyeingWorkOrder entity) {
        this.id = entity.getId();
        this.dyeingWorkOrderNo = entity.getDyeingWorkOrderNo();
        this.processContactDate = entity.getProcessContactDate();
        this.deliveryDate = entity.getDeliveryDate();
        this.vendorId = entity.getVendorId();
        this.salesOrderNo = entity.getSalesOrderNo();
        this.consigneeId = entity.getConsigneeId();
        this.lapDipStatusId = entity.getLapDipStatusId();
        this.firstYardageId = entity.getFirstYardageId();
        this.totalAmount = entity.getTotalAmount();
        this.remarks = entity.getRemarks();
        this.activeFlag = entity.getActiveFlag();
        this.items = entity.getItems().stream()
                .map(DyeingWorkOrderItemDTO::new)
                .collect(Collectors.toList());
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

    public List<DyeingWorkOrderItemDTO> getItems() {
        return items;
    }
    public void setItems(List<DyeingWorkOrderItemDTO> items) {
        this.items = items;
    }

}
