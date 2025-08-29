package com.tech3.erp.controller;

import com.tech3.erp.dto.CurrencyMasterDTO;
import com.tech3.erp.service.CurrencyMasterService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@Tag(name = "Currency Controller", description = "APIs for Currency management")
@Validated
public class CurrencyMasterController {

    private final CurrencyMasterService currencyMasterService;

    public CurrencyMasterController(CurrencyMasterService currencyMasterService) {
        this.currencyMasterService = currencyMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Currency", description = "Adds a new currency.")
    public ResponseEntity<Object> createCurrency(@Valid @RequestBody CurrencyMasterDTO currencyMasterDTO) {
        try {
            CurrencyMasterDTO createdCurrency = currencyMasterService.createCurrency(currencyMasterDTO);
            return ResponseUtil.success("Currency created successfully", createdCurrency);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Currency by ID", description = "Fetch a currency using its unique ID.")
    public ResponseEntity<Object> getCurrencyById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Currency fetched successfully", currencyMasterService.getCurrencyById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Currencies", description = "Retrieve a list of all currencies.")
    public ResponseEntity<Object> getAllCurrencies() {
        return ResponseUtil.success("Currencies fetched successfully", currencyMasterService.getAllCurrencies());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Currency", description = "Update currency details based on ID.")
    public ResponseEntity<Object> updateCurrency(@PathVariable Long id, @Valid @RequestBody CurrencyMasterDTO currencyMasterDTO) {
        try {
            return ResponseUtil.success("Currency updated successfully", currencyMasterService.updateCurrency(id, currencyMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Currency", description = "Deletes a currency by ID.")
//    public ResponseEntity<Object> deleteCurrency(@PathVariable Long id) {
//        try {
//            currencyMasterService.deleteCurrency(id);
//            return ResponseUtil.success("Currency deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Currency", description = "Deletes a Currency by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	currencyMasterService.deleteCurrency(id);
            return ResponseUtil.success("Currency deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Currency", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
