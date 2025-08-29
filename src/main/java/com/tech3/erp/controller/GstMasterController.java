package com.tech3.erp.controller;

import com.tech3.erp.dto.GstMasterDTO;
import com.tech3.erp.service.GstMasterService;
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
@RequestMapping("/api/gst")
@Tag(name = "Gst Master Controller", description = "APIs for Gst Master management")
@Validated
public class GstMasterController {

    private final GstMasterService gstMasterService;

    public GstMasterController(GstMasterService gstMasterService) {
        this.gstMasterService = gstMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Gst", description = "Adds a new Gst.")
    public ResponseEntity<Object> createGstMaster(@Valid @RequestBody GstMasterDTO gstMasterDTO) {
        try {
        	GstMasterDTO createdTerm = gstMasterService.createGstMaster(gstMasterDTO);
            return ResponseUtil.success("Gst created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Gst by ID", description = "Fetch a Gst using its unique ID.")
    public ResponseEntity<Object> getGstMasterById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Gst fetched successfully", gstMasterService.getGstMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Gst", description = "Retrieve a list of all Gst.")
    public ResponseEntity<Object> getAllGstMaster() {
        return ResponseUtil.success("Gst fetched successfully", gstMasterService.getAllGstMaster());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Gst", description = "Update Gst details based on ID.")
    public ResponseEntity<Object> updateGstMaster(@PathVariable Long id, @Valid @RequestBody GstMasterDTO gstMasterDTO) {
        try {
            return ResponseUtil.success("Gst updated successfully", gstMasterService.updateGstMaster(id, gstMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Gst", description = "Deletes a Gst by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	gstMasterService.deleteGstMaster(id);
            return ResponseUtil.success("Gst deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Gst", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
