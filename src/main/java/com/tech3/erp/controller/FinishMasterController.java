package com.tech3.erp.controller;

import com.tech3.erp.dto.FinishMasterDTO;
import com.tech3.erp.service.FinishMasterService;
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
@RequestMapping("/api/finish-master")
@Tag(name = "Finish Master Controller", description = "APIs for Finish Master management")
@Validated
public class FinishMasterController {

	private FinishMasterService finishMasterService;

    public FinishMasterController(FinishMasterService finishMasterService) {
        this.finishMasterService = finishMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Finish Master", description = "Adds a new Finish Master.")
    public ResponseEntity<Object> createFinishMaster(@Valid @RequestBody FinishMasterDTO finishMasterDTO) {
        try {
        	FinishMasterDTO createdTerm = finishMasterService.createFinishMaster(finishMasterDTO);
            return ResponseUtil.success("Finish Master created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Uom by ID", description = "Fetch a Finish Master using its unique ID.")
    public ResponseEntity<Object> getFinishMasterById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Finish Master fetched successfully", finishMasterService.getFinishMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Finish Master", description = "Retrieve a list of all Finish Master.")
    public ResponseEntity<Object> getAllFinishMaster() {
        return ResponseUtil.success("Finish Master fetched successfully", finishMasterService.getAllFinishMaster());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Finish Master", description = "Update Finish Master details based on ID.")
    public ResponseEntity<Object> updateFinishMaster(@PathVariable Long id, @Valid @RequestBody FinishMasterDTO finishMasterDTO) {
        try {
            return ResponseUtil.success("Shipment term updated successfully", finishMasterService.updateFinishMaster(id, finishMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Finish Master", description = "Deletes a uom by ID.")
//    public ResponseEntity<Object> deleteUom(@PathVariable Long id) {
//        try {
//        	finishMasterService.deleteFinishMaster(id);
//            return ResponseUtil.success("Finish Master deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Finish Master", description = "Deletes a Finish Master by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	finishMasterService.deleteFinishMaster(id);
            return ResponseUtil.success("Finish Master deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Finish Master", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
