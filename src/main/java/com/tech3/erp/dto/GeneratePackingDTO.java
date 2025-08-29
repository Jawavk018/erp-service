//package com.tech3.erp.dto;
//
//import java.util.Date;
//import java.util.List;
//
//import com.tech3.erp.entity.GeneratePacking;
//
//public class GeneratePackingDTO {
//    private Long id;
//    private Date packingDate;
//    private Long buyerId;
//    private Long salesOrderId;
//    private Long warehouseId;
//    private String tareWeight;
//    private String grossWeight;
//    private String packingSlipNo;
//    private List<Long> lotId;
//
//    public GeneratePackingDTO() {
//    }
//
//    // Constructor that takes GeneratePacking entity
//    public GeneratePackingDTO(GeneratePacking entity) {
//        this.id = entity.getId();
//        this.packingDate = entity.getPackingDate();
//        this.buyerId = entity.getBuyerId();
//        this.salesOrderId = entity.getSalesOrderId();
//        this.warehouseId = entity.getWarehouseId();
//        this.tareWeight = entity.getTareWeight();
//        this.grossWeight = entity.getGrossWeight();
//        this.packingSlipNo = entity.getPackingSlipNo();
//        this.lotId = entity.getLotId();
//    }
//
//    // All-arguments constructor (optional)
//    public GeneratePackingDTO(Long id, Date packingDate, Long buyerId, Long salesOrderId, 
//                            Long warehouseId, String tareWeight, String grossWeight, 
//                            String packingSlipNo, List<Long> lotId) {
//        this.id = id;
//        this.packingDate = packingDate;
//        this.buyerId = buyerId;
//        this.salesOrderId = salesOrderId;
//        this.warehouseId = warehouseId;
//        this.tareWeight = tareWeight;
//        this.grossWeight = grossWeight;
//        this.packingSlipNo = packingSlipNo;
//        this.lotId = lotId;
//    }
//
//	// Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Date getPackingDate() {
//        return packingDate;
//    }
//
//    public void setPackingDate(Date packingDate) {
//        this.packingDate = packingDate;
//    }
//
//    public Long getBuyerId() {
//        return buyerId;
//    }
//
//    public void setBuyerId(Long buyerId) {
//        this.buyerId = buyerId;
//    }
//
//    public Long getSalesOrderId() {
//        return salesOrderId;
//    }
//
//    public void setSalesOrderId(Long salesOrderId) {
//        this.salesOrderId = salesOrderId;
//    }
//
//    public Long getWarehouseId() {
//        return warehouseId;
//    }
//
//    public void setWarehouseId(Long warehouseId) {
//        this.warehouseId = warehouseId;
//    }
//
//    public String getTareWeight() {
//        return tareWeight;
//    }
//
//    public void setTareWeight(String tareWeight) {
//        this.tareWeight = tareWeight;
//    }
//
//    public String getGrossWeight() {
//        return grossWeight;
//    }
//
//    public void setGrossWeight(String grossWeight) {
//        this.grossWeight = grossWeight;
//    }
//
//    public String getPackingSlipNo() {
//        return packingSlipNo;
//    }
//
//    public void setPackingSlipNo(String packingSlipNo) {
//        this.packingSlipNo = packingSlipNo;
//    }
//
//    public List<Long> getLotId() {
//        return lotId;
//    }
//
//    public void setLotId(List<Long> lotId) {
//        this.lotId = lotId;
//    }
//}




package com.tech3.erp.dto;

import java.util.Date;
import java.util.List;

public class GeneratePackingDTO {
    private Long id;
    private Date packingDate;
    private Long buyerId;
    private Long salesOrderId;
    private Long warehouseId;
    private String tareWeight;
    private String grossWeight;
    private String packingSlipNo;
    private List<GeneratePackingItemDTO> items;

    // Constructors
    public GeneratePackingDTO() {
    }

    public GeneratePackingDTO(Long id, Date packingDate, Long buyerId, Long salesOrderId, 
                            Long warehouseId, String tareWeight, String grossWeight, 
                            String packingSlipNo,  List<GeneratePackingItemDTO> items) {
        this.id = id;
        this.packingDate = packingDate;
        this.buyerId = buyerId;
        this.salesOrderId = salesOrderId;
        this.warehouseId = warehouseId;
        this.tareWeight = tareWeight;
        this.grossWeight = grossWeight;
        this.packingSlipNo = packingSlipNo;
        this.items = items;
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

    public List<GeneratePackingItemDTO> getItems() {
        return items;
    }

    public void setItems(List<GeneratePackingItemDTO> items) {
        this.items = items;
    }
}
