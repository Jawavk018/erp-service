package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "currency_master", schema = "masters")
public class CurrencyMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code", nullable = false, length = 10)
    @NotBlank(message = "Currency code is required")
    @Size(max = 10, message = "Currency code must be up to 10 characters")
    private String currencyCode;

    @Column(name = "currency_name", nullable = false, length = 50)
    @NotBlank(message = "Currency name is required")
    @Size(max = 50, message = "Currency name must be up to 50 characters")
    private String currencyName;

    @Column(name = "symbol", nullable = false, length = 10)
    @NotBlank(message = "Symbol is required")
    @Size(max = 10, message = "Symbol must be up to 10 characters")
    private String symbol;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    // Default constructor
    public CurrencyMaster() {}

    // Constructor with parameters
    public CurrencyMaster(String currencyCode, String currencyName, String symbol, boolean activeFlag) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.symbol = symbol;
        this.activeFlag = activeFlag;
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
