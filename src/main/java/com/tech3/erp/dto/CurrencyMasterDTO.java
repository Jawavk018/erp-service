package com.tech3.erp.dto;

import com.tech3.erp.entity.CurrencyMaster;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CurrencyMasterDTO {
    private Long id;

    @NotBlank(message = "Currency code is required")
    @Size(max = 10, message = "Currency code must not exceed 10 characters")
    private String currencyCode;

    @NotBlank(message = "Currency name is required")
    @Size(max = 50, message = "Currency name must not exceed 50 characters")
    private String currencyName;

    @NotBlank(message = "Symbol is required")
    @Size(max = 10, message = "Symbol must not exceed 10 characters")
    private String symbol;

    private boolean activeFlag = true;

    // Default constructor
    public CurrencyMasterDTO() {
    }

    // Constructor with parameters
    public CurrencyMasterDTO(Long id, String currencyCode, String currencyName, String symbol, boolean activeFlag) {
        this.id = id;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.symbol = symbol;
        this.activeFlag = activeFlag;
    }

    // Constructor to convert from entity to DTO
    public CurrencyMasterDTO(CurrencyMaster currencyMaster) {
        this.id = currencyMaster.getId();
        this.currencyCode = currencyMaster.getCurrencyCode();
        this.currencyName = currencyMaster.getCurrencyName();
        this.symbol = currencyMaster.getSymbol();
        this.activeFlag = currencyMaster.getActiveFlag();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public String getCurrencyName() { return currencyName; }
    public void setCurrencyName(String currencyName) { this.currencyName = currencyName; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
