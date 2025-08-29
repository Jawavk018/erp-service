package com.tech3.erp.controller;

import com.tech3.erp.dto.UomDTO;
import com.tech3.erp.service.UomService;
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
@RequestMapping("/api/uom")
@Tag(name = "Uom Controller", description = "APIs for Uom management")
@Validated
public class UomController {

    private final UomService uomService;

    public UomController(UomService uomService) {
        this.uomService = uomService;
    }

    @PostMapping
    @Operation(summary = "Create a new Uom", description = "Adds a new uom.")
    public ResponseEntity<Object> createUom(@Valid @RequestBody UomDTO uomDTO) {
        try {
        	UomDTO createdTerm = uomService.createUom(uomDTO);
            return ResponseUtil.success("Uom created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Uom by ID", description = "Fetch a uom using its unique ID.")
    public ResponseEntity<Object> getShipmentTermById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Uom fetched successfully", uomService.getUomById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Uom", description = "Retrieve a list of all uom.")
    public ResponseEntity<Object> getAllUom() {
        return ResponseUtil.success("Uom fetched successfully", uomService.getAllUom());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Uom", description = "Update uom details based on ID.")
    public ResponseEntity<Object> updateUom(@PathVariable Long id, @Valid @RequestBody UomDTO uomDTO) {
        try {
            return ResponseUtil.success("Shipment term updated successfully", uomService.updateUom(id, uomDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Uom", description = "Deletes a uom by ID.")
//    public ResponseEntity<Object> deleteUom(@PathVariable Long id) {
//        try {
//        	uomService.deleteUom(id);
//            return ResponseUtil.success("Uom deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Uom", description = "Deletes a Uom by ID.")
    public ResponseEntity<Object> deleteUom(@PathVariable Long id) {
        try {
        	uomService.deleteUom(id);
            return ResponseUtil.success("Uom deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Uom", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
