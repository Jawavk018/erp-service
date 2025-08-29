package com.tech3.erp.controller;

import com.tech3.erp.dto.FabricTypeDTO;
import com.tech3.erp.service.FabricTypeService;
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
@RequestMapping("/api/fabric-type")
@Tag(name = "FabricType Controller", description = "APIs for FabricType management")
@Validated
public class FabricTypeController {

    private final FabricTypeService fabricTypeService;

    public FabricTypeController(FabricTypeService fabricTypeService) {
        this.fabricTypeService = fabricTypeService;
    }

    @PostMapping
    @Operation(summary = "Create a new FabricType", description = "Adds a new fabric type.")
    public ResponseEntity<Object> createFabricType(@Valid @RequestBody FabricTypeDTO fabricTypeDTO) {
        try {
            FabricTypeDTO createdFabricType = fabricTypeService.createFabricType(fabricTypeDTO);
            return ResponseUtil.success("Fabric type created successfully", createdFabricType);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get FabricType by ID", description = "Fetch a FabricType using its unique ID.")
    public ResponseEntity<Object> getFabricTypeById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Fabric type fetched successfully", fabricTypeService.getFabricTypeById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all FabricTypes", description = "Retrieve a list of all fabric types.")
    public ResponseEntity<Object> getAllFabricTypes() {
        return ResponseUtil.success("Fabric types fetched successfully", fabricTypeService.getAllFabricTypes());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update FabricType", description = "Update fabric type details based on ID.")
    public ResponseEntity<Object> updateFabricType(@PathVariable Long id, @Valid @RequestBody FabricTypeDTO fabricTypeDTO) {
        try {
            return ResponseUtil.success("Fabric type updated successfully", fabricTypeService.updateFabricType(id, fabricTypeDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete FabricType", description = "Deletes a fabric type by ID.")
//    public ResponseEntity<Object> deleteFabricType(@PathVariable Long id) {
//        try {
//            fabricTypeService.deleteFabricType(id);
//            return ResponseUtil.success("Fabric type deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete FabricType", description = "Deletes a FabricType by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	fabricTypeService.deleteFabricType(id);
            return ResponseUtil.success("FabricType deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the FabricType", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
