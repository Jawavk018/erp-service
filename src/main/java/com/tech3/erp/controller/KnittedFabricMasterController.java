package com.tech3.erp.controller;

import com.tech3.erp.dto.KnittedFabricMasterDTO;
import com.tech3.erp.service.KnittedFabricMasterService;
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
@RequestMapping("/api/knitted-fabric-master")
@Tag(name = "Knitted Fabric Master Controller", description = "APIs for Knitted Fabric Master management")
@Validated
public class KnittedFabricMasterController {

    private final KnittedFabricMasterService knittedFabricMasterService;

    public KnittedFabricMasterController(KnittedFabricMasterService knittedFabricMasterService) {
        this.knittedFabricMasterService = knittedFabricMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Fabric Master", description = "Adds a new Fabric Master entry.")
    public ResponseEntity<Object> createFabricMaster(@Valid @RequestBody KnittedFabricMasterDTO knittedFabricMasterDTO) {
        try {
            KnittedFabricMasterDTO createdFabric = knittedFabricMasterService.createFabricMaster(knittedFabricMasterDTO);
            return ResponseUtil.success("Fabric created successfully", createdFabric);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Fabric Master by ID", description = "Fetch a Fabric Master entry using its unique ID.")
    public ResponseEntity<Object> getFabric(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Fabric fetched successfully", knittedFabricMasterService.getFabricMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Fabric Masters", description = "Retrieve a list of all Fabric Masters.")
    public ResponseEntity<Object> getAllFabricMasters() {
        List<KnittedFabricMasterDTO> fabrics = knittedFabricMasterService.getAllFabricMasters();
        return ResponseUtil.success("Fabrics fetched successfully", fabrics);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Fabric Master", description = "Update Fabric Master details based on ID.")
    public ResponseEntity<Object> updateFabricMaster(@PathVariable Long id, @Valid @RequestBody KnittedFabricMasterDTO knittedFabricMasterDTO) {
        try {
            return ResponseUtil.success("Fabric updated successfully", knittedFabricMasterService.updateFabricMaster(id, knittedFabricMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Fabric Master", description = "Deletes a Fabric Master by ID.")
//    public ResponseEntity<Object> deleteFabricMaster(@PathVariable Long id) {
//        try {
//            knittedFabricMasterService.deleteFabricMaster(id);
//            return ResponseUtil.success("Fabric deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Fabric Master", description = "Deletes a Fabric Master by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	knittedFabricMasterService.deleteFabricMaster(id);
            return ResponseUtil.success("Fabric Master deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Fabric Master", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
