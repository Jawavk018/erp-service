package com.tech3.erp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.DefectMasterDTO;
import com.tech3.erp.dto.GstMasterDTO;
import com.tech3.erp.service.DefectMasterService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/defects")
@Tag(name = "Defect Master Controller", description = "APIs for Defect Master management")
public class DefectMasterController {

    private final DefectMasterService defectMasterService;

    @Autowired
    public DefectMasterController(DefectMasterService defectMasterService) {
        this.defectMasterService = defectMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Defect", description = "Adds a new Defect.")
    public ResponseEntity<Object> createDefectMaster(@Valid @RequestBody DefectMasterDTO defectMasterDTO) {
        try {
        	DefectMasterDTO createdTerm = defectMasterService.createDefectMaster(defectMasterDTO);
            return ResponseUtil.success("Defect created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<DefectMasterDTO>> getAllDefectMasters() {
        List<DefectMasterDTO> defects = defectMasterService.getAllDefectMasters();
        return ResponseEntity.ok(defects);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get Defect by ID", description = "Fetch a Defect using its unique ID.")
    public ResponseEntity<Object> getDefectMasterById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Gst fetched successfully", defectMasterService.getDefectMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Defect", description = "Update Defect details based on ID.")
    public ResponseEntity<Object> updatedDefect(@PathVariable Long id, @Valid @RequestBody DefectMasterDTO defectMasterDTO) {
        try {
            return ResponseUtil.success("Defect updated successfully", defectMasterService.updateDefectMaster(id, defectMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Defect", description = "Deletes a Defect by ID.")
    public ResponseEntity<Object> deleteDefectMaster(@PathVariable Long id) {
        try {
        	defectMasterService.deleteDefectMaster(id);
            return ResponseUtil.success("Defect deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Defect", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
