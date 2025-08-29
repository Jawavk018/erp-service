package com.tech3.erp.dto;

import com.tech3.erp.entity.ShipmentMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ShipmentModeDTO {
    private Long id;

    @NotBlank(message = "Mode name is required")
    @Size(min = 1, max = 50, message = "Mode name must be between 3 and 50 characters")
    private String modeName;

    private String description;
    private boolean activeFlag;

    public ShipmentModeDTO() {}

    public ShipmentModeDTO(Long id, String modeName, String description, boolean activeFlag) {
        this.id = id;
        this.modeName = modeName;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public ShipmentModeDTO(ShipmentMode shipmentMode) {
        this.id = shipmentMode.getId();
        this.modeName = shipmentMode.getModeName();
        this.description = shipmentMode.getDescription();
        this.activeFlag = shipmentMode.getActiveFlag();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModeName() { return modeName; }
    public void setModeName(String modeName) { this.modeName = modeName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
