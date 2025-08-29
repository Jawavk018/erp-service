package com.tech3.erp.controller;

import com.tech3.erp.dto.ShipmentTermsDTO;
import com.tech3.erp.service.ShipmentTermsService;
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
@RequestMapping("/api/shipment-terms")
@Tag(name = "Shipment Terms Controller", description = "APIs for Shipment Terms management")
@Validated
public class ShipmentTermsController {

    private final ShipmentTermsService shipmentTermsService;

    public ShipmentTermsController(ShipmentTermsService shipmentTermsService) {
        this.shipmentTermsService = shipmentTermsService;
    }

    @PostMapping
    @Operation(summary = "Create a new Shipment Term", description = "Adds a new shipment term.")
    public ResponseEntity<Object> createShipmentTerm(@Valid @RequestBody ShipmentTermsDTO shipmentTermsDTO) {
        try {
            ShipmentTermsDTO createdTerm = shipmentTermsService.createShipmentTerm(shipmentTermsDTO);
            return ResponseUtil.success("Shipment term created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Shipment Term by ID", description = "Fetch a shipment term using its unique ID.")
    public ResponseEntity<Object> getShipmentTermById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Shipment term fetched successfully", shipmentTermsService.getShipmentTermById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Shipment Terms", description = "Retrieve a list of all shipment terms.")
    public ResponseEntity<Object> getAllShipmentTerms() {
        return ResponseUtil.success("Shipment terms fetched successfully", shipmentTermsService.getAllShipmentTerms());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Shipment Term", description = "Update shipment term details based on ID.")
    public ResponseEntity<Object> updateShipmentTerm(@PathVariable Long id, @Valid @RequestBody ShipmentTermsDTO shipmentTermsDTO) {
        try {
            return ResponseUtil.success("Shipment term updated successfully", shipmentTermsService.updateShipmentTerm(id, shipmentTermsDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Shipment Term", description = "Deletes a shipment term by ID.")
//    public ResponseEntity<Object> deleteShipmentTerm(@PathVariable Long id) {
//        try {
//            shipmentTermsService.deleteShipmentTerm(id);
//            return ResponseUtil.success("Shipment term deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Shipment Term", description = "Deletes a Shipment Term by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	shipmentTermsService.deleteShipmentTerm(id);
            return ResponseUtil.success("Shipment Term deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Shipment Term", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
