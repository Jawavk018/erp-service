package com.tech3.erp.controller;

import com.tech3.erp.dto.FlangeDTO;
import com.tech3.erp.service.FlangeService;
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
@RequestMapping("/api/flange")
@Tag(name = "Flange Master Controller", description = "APIs for Flange  management")
@Validated
public class FlangeController {

    private final FlangeService flangeService;

    public FlangeController(FlangeService flangeService) {
        this.flangeService = flangeService;
    }

    @PostMapping
    @Operation(summary = "Create a new Flange", description = "Adds a new Flange.")
    public ResponseEntity<Object> createFlange(@Valid @RequestBody FlangeDTO flangeDTO) {
        try {
        	FlangeDTO createFlange = flangeService.createFlange(flangeDTO);
            return ResponseUtil.success("Flange created successfully", createFlange);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Flange by ID", description = "Fetch a Flange using their unique ID.")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Flange fetched successfully", flangeService.getFlangeById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Countries", description = "Retrieve a list of all Countries.")
    public ResponseEntity<Object> getAllCountries() {
        return ResponseUtil.success("Countries fetched successfully", flangeService.getAllFlanges());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Flange", description = "Update Flange details based on ID.")
    public ResponseEntity<Object> updateFlange(@PathVariable Long id, @Valid @RequestBody FlangeDTO flangeDTO) {
        try {
            return ResponseUtil.success("Flange updated successfully", flangeService.updateFlange(id, flangeDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Flange", description = "Deletes a Flange by ID.")
//    public ResponseEntity<Object> deleteFlange(@PathVariable Long id) {
//        try {
//        	flangeService.deleteFlange(id);
//            return ResponseUtil.success("Flange deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Flange", description = "Deletes a Flange by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	flangeService.deleteFlange(id);
            return ResponseUtil.success("Flange deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Flange", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
