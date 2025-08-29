
package com.tech3.erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech3.erp.entity.JobworkFabricReceiveItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class JobworkFabricReceiveItemDTO {

    private Long id;
    private Long jobworkFabricReceiveId;
    private Long weavingContractItemId;
    private BigDecimal quantityReceived;
    private BigDecimal price;
    private Boolean activeFlag;

    @JsonProperty("pieceEntries")
    private List<PieceEntryDTO> pieceEntries;

    public JobworkFabricReceiveItemDTO() {}

    public JobworkFabricReceiveItemDTO(JobworkFabricReceiveItem item) {
        this.id = item.getId();
        this.jobworkFabricReceiveId = item.getJobworkFabricReceive().getId();
        this.weavingContractItemId = item.getWeavingContractItemId(); // Replace with item.getPoItem().getId() if needed
        this.quantityReceived = item.getQuantityReceived();
        this.price = item.getPrice();
        this.activeFlag = item.getActiveFlag();
        if (item.getPieceEntries() != null) {
            this.pieceEntries = item.getPieceEntries().stream()
                .map(PieceEntryDTO::new)
                .collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobworkFabricReceiveId() {
        return jobworkFabricReceiveId;
    }

    public void setJobworkFabricReceiveId(Long jobworkFabricReceiveId) {
        this.jobworkFabricReceiveId = jobworkFabricReceiveId;
    }

    public Long getWeavingContractItemId() {
        return weavingContractItemId;
    }

    public void setWeavingContractItemId(Long weavingContractItemId) {
        this.weavingContractItemId = weavingContractItemId;
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

    public List<PieceEntryDTO> getPieceEntries() {
        return pieceEntries;
    }

    public void setPieceEntries(List<PieceEntryDTO> pieceEntries) {
        this.pieceEntries = pieceEntries;
    }
}


