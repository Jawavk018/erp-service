package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.PurchaseInwardItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseInwardItemDTO {

    private Long id;
    private Long inwardId;
    private Long poItemId;
    private BigDecimal quantityReceived;
    private BigDecimal price;
    private Boolean activeFlag;

    @JsonProperty("lotEntries")
    private List<LotEntryDTO> lotEntries;

    public PurchaseInwardItemDTO() {}

    public PurchaseInwardItemDTO(PurchaseInwardItem item) {
        this.id = item.getId();
        this.inwardId = item.getPurchaseInward().getId();
        this.poItemId = item.getPurchaseOrderItemId(); // Replace with item.getPoItem().getId() if needed
        this.quantityReceived = item.getQuantityReceived();
        this.price = item.getPrice();
        this.activeFlag = item.getActiveFlag();
        if (item.getLotEntries() != null) {
            this.lotEntries = item.getLotEntries().stream()
                .map(LotEntryDTO::new)
                .collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInwardId() {
        return inwardId;
    }

    public void setInwardId(Long inwardId) {
        this.inwardId = inwardId;
    }

    public Long getPoItemId() {
        return poItemId;
    }

    public void setPoItemId(Long poItemId) {
        this.poItemId = poItemId;
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

    public List<LotEntryDTO> getLotEntries() {
        return lotEntries;
    }

    public void setLotEntries(List<LotEntryDTO> lotEntries) {
        this.lotEntries = lotEntries;
    }
}


