package com.tech3.erp.controller;

import com.tech3.erp.dto.ShipmentModeDTO;
import com.tech3.erp.service.ShipmentModeService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipment-mode")
@Tag(name = "Shipment Mode Controller", description = "APIs for Shipment Mode management")
@Validated
public class ShipmentModeController {

    private final ShipmentModeService shipmentModeService;

    public ShipmentModeController(ShipmentModeService shipmentModeService) {
        this.shipmentModeService = shipmentModeService;
    }

    @PostMapping
    @Operation(summary = "Create a new Shipment Mode", description = "Adds a new shipment mode.")
    public ResponseEntity<Object> createShipmentMode(@Valid @RequestBody ShipmentModeDTO shipmentModeDTO) {
        try {
            ShipmentModeDTO createdMode = shipmentModeService.createShipmentMode(shipmentModeDTO);
            return ResponseUtil.success("Shipment Mode created successfully", createdMode);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Shipment Mode by ID", description = "Fetch a Shipment Mode using its unique ID.")
    public ResponseEntity<Object> getShipmentModeById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Shipment Mode fetched successfully", shipmentModeService.getShipmentModeById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Shipment Modes", description = "Retrieve a list of all shipment modes.")
    public ResponseEntity<Object> getAllShipmentModes() {
        List<ShipmentModeDTO> modes = shipmentModeService.getAllShipmentModes();
        return ResponseUtil.success("Shipment Modes fetched successfully", modes);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Shipment Mode", description = "Update shipment mode details based on ID.")
    public ResponseEntity<Object> updateShipmentMode(@PathVariable Long id, @Valid @RequestBody ShipmentModeDTO shipmentModeDTO) {
        try {
            return ResponseUtil.success("Shipment Mode updated successfully", shipmentModeService.updateShipmentMode(id, shipmentModeDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Shipment Mode", description = "Deletes a shipment mode by ID.")
//    public ResponseEntity<Object> deleteShipmentMode(@PathVariable Long id) {
//        try {
//            shipmentModeService.deleteShipmentMode(id);
//            return ResponseUtil.success("Shipment Mode deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    

	@DeleteMapping("/{id}")
	    @Operation(summary = "Delete Shipment Mode", description = "Deletes a Shipment Mode by ID.")
	    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
	        try {
	        	shipmentModeService.deleteShipmentMode(id);
	            return ResponseUtil.success("Shipment Mode deleted successfully", null);
	        } catch (EntityNotFoundException e) {
	            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
	        } catch (IllegalStateException e) {
	            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
	        } catch (Exception e) {
	            return ResponseUtil.error("An error occurred while deleting the Shipment Mode", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
