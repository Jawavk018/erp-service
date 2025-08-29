package com.tech3.erp.controller;

import com.tech3.erp.dto.WovenFabricMasterDTO;
import com.tech3.erp.service.WovenFabricMasterService;
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
@RequestMapping("/api/fabric-master")
@Tag(name = "Fabric Master Controller", description = "APIs for Fabric Master management")
@Validated
public class WovenFabricMasterController {

    private final WovenFabricMasterService wovenFabricMasterService;

    public WovenFabricMasterController(WovenFabricMasterService wovenFabricMasterService) {
        this.wovenFabricMasterService = wovenFabricMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Fabric Master", description = "Adds a new Fabric Master entry.")
    public ResponseEntity<Object> createFabricMaster(@Valid @RequestBody WovenFabricMasterDTO wovenFabricMasterDTO) {
        try {
            WovenFabricMasterDTO createdFabric = wovenFabricMasterService.createFabricMaster(wovenFabricMasterDTO);
            return ResponseUtil.success("Fabric created successfully", createdFabric);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Fabric Master by ID", description = "Fetch a Fabric Master entry using its unique ID.")
    public ResponseEntity<Object> getFabric(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Fabric fetched successfully", wovenFabricMasterService.getFabricMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Fabric Masters", description = "Retrieve a list of all Fabric Masters.")
    public ResponseEntity<Object> getAllFabricMasters() {
        List<WovenFabricMasterDTO> fabrics = wovenFabricMasterService.getAllFabricMasters();
        return ResponseUtil.success("Fabrics fetched successfully", fabrics);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Fabric Master", description = "Update Fabric Master details based on ID.")
    public ResponseEntity<Object> updateFabricMaster(@PathVariable Long id, @Valid @RequestBody WovenFabricMasterDTO wovenFabricMasterDTO) {
        try {
            return ResponseUtil.success("Fabric updated successfully", wovenFabricMasterService.updateFabricMaster(id, wovenFabricMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Fabric Master", description = "Deletes a Fabric Master by ID.")
//    public ResponseEntity<Object> deleteFabricMaster(@PathVariable Long id) {
//        try {
//            wovenFabricMasterService.deleteFabricMaster(id);
//            return ResponseUtil.success("Fabric deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Woven Fabric", description = "Deletes a Woven Fabric by ID.")
    public ResponseEntity<Object> deleteFabricMaster(@PathVariable Long id) {
        try {
        	wovenFabricMasterService.deleteFabricMaster(id);
            return ResponseUtil.success("Woven Fabric deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Woven Fabric", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/basic/{id}")
    public ResponseEntity<String> getFabricDetails(@PathVariable Long id) {
        String json = wovenFabricMasterService.getFabricDetails(id);
        return ResponseEntity.ok(json);
    }
    
   
//    @GetMapping("/by-fabricTypeId")
//    public List<WovenFabricMasterDTO> getFabricByFabricTypeId(@RequestParam Short fabricTypeId) {
//        return wovenFabricMasterService.getFabricByFabricTypeId(fabricTypeId);
//    }
    
}
