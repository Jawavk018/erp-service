package com.tech3.erp.controller;

import com.tech3.erp.util.ResponseUtil;
import com.tech3.erp.dto.WarehouseDTO;
import com.tech3.erp.service.WarehouseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
@Tag(name = "Warehouse Master Controller", description = "APIs for Warehouse  management")
@Validated
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    @Operation(summary = "Create a new Warehouse", description = "Adds a new Warehouse.")
    public ResponseEntity<Object> createWarehouse(@Valid @RequestBody WarehouseDTO warehouseDTO) {
        try {
        	WarehouseDTO createWarehouse = warehouseService.createWarehouse(warehouseDTO);
            return ResponseUtil.success("Warehouse created successfully", createWarehouse);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Warehouse by ID", description = "Fetch a Warehouse using their unique ID.")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Warehouse fetched successfully", warehouseService.getWarehouseById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Countries", description = "Retrieve a list of all Countries.")
    public ResponseEntity<Object> getAllCountries() {
        return ResponseUtil.success("Countries fetched successfully", warehouseService.getAllWarehouse());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Warehouse", description = "Update Warehouse details based on ID.")
    public ResponseEntity<Object> updateWarehouse(@PathVariable Long id, @Valid @RequestBody WarehouseDTO warehouseDTO) {
        try {
            return ResponseUtil.success("Warehouse updated successfully", warehouseService.updateWarehouse(id, warehouseDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Warehouse", description = "Deletes a Warehouse by ID.")
//    public ResponseEntity<Object> deleteWarehouse(@PathVariable Long id) {
//        try {
//        	warehouseService.deleteWarehouse(id);
//            return ResponseUtil.success("Warehouse deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Warehouse", description = "Deletes a Warehouse by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	warehouseService.deleteWarehouse(id);
            return ResponseUtil.success("Warehouse deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Warehouse", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
