package com.tech3.erp.controller;

import com.tech3.erp.dto.FabricInspectionDTO;
import com.tech3.erp.entity.FabricInspection;
import com.tech3.erp.service.FabricInspectionService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabric-inspections")
@Tag(name = "Fabric Inspections Controller", description = "APIs for Fabric Inspections management")
public class FabricInspectionController {

    @Autowired
    private FabricInspectionService fabricInspectionService;

    @PostMapping
    @Operation(summary = "Create a new Fabric Inspection", description = "Adds a new Fabric Inspection.")
    public ResponseEntity<Object> createFabricInspection(@Valid @RequestBody FabricInspectionDTO fabricInspectionDTO) {
        try {
            FabricInspection created = fabricInspectionService.createFabricInspection(fabricInspectionDTO);
            return ResponseUtil.success("Fabric Inspection created successfully", created);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Fabric Inspections", description = "Fetch all Fabric Inspections as DTOs.")
    public ResponseEntity<Object> getAllFabricInspections() {
        List<FabricInspectionDTO> inspections = fabricInspectionService.getAllFabricInspections();
        return ResponseUtil.success("Fabric inspections fetched successfully", inspections);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Fabric Inspection by ID", description = "Fetch a Fabric Inspection by its unique ID.")
    public ResponseEntity<Object> getFabricInspectionById(@PathVariable Long id) {
        FabricInspection inspection = fabricInspectionService.getFabricInspectionById(id);
        if (inspection != null) {
            return ResponseUtil.success("Fabric inspection fetched successfully", inspection);
        } else {
            return ResponseUtil.error("Fabric Inspection not found", HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update Fabric Inspection", description = "Update a Fabric Inspection by its ID.")
    public ResponseEntity<Object> updateFabricInspection(@PathVariable Long id, @Valid @RequestBody FabricInspectionDTO fabricInspectionDTO) {
        try {
            FabricInspection updated = fabricInspectionService.updateFabricInspection(id, fabricInspectionDTO);
            return ResponseUtil.success("Fabric Inspection updated successfully", updated);
        } catch (RuntimeException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Fabric Inspection", description = "Soft delete a Fabric Inspection by its ID.")
    public ResponseEntity<Object> deleteFabricInspection(@PathVariable Long id) {
        boolean deleted = fabricInspectionService.deleteFabricInspection(id);
        if (deleted) {
            return ResponseUtil.success("Fabric Inspection deleted successfully", null);
        } else {
            return ResponseUtil.error("Fabric Inspection not found", HttpStatus.NOT_FOUND);
        }
    }
}