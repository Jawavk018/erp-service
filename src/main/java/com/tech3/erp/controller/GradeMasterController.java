package com.tech3.erp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.GradeMasterDTO;
import com.tech3.erp.dto.GradeMasterDTO;
import com.tech3.erp.service.GradeMasterService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
@Tag(name = "Grand Master Controller", description = "APIs for Grand Master management")

public class GradeMasterController {

    private final GradeMasterService gradeMasterService;

    @Autowired
    public GradeMasterController(GradeMasterService gradeMasterService) {
        this.gradeMasterService = gradeMasterService;
    }

//    @PostMapping
//    public ResponseEntity<GradeMasterDTO> createGradeMaster(@RequestBody GradeMasterDTO dto) {
//        GradeMasterDTO createdGrade = gradeMasterService.createGradeMaster(dto);
//        return ResponseEntity.ok(createdGrade);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<GradeMasterDTO>> getAllGradeMasters() {
//        List<GradeMasterDTO> grades = gradeMasterService.getAllGradeMasters();
//        return ResponseEntity.ok(grades);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GradeMasterDTO> getGradeMasterById(@PathVariable Long id) {
//        GradeMasterDTO grade = gradeMasterService.getGradeMasterById(id);
//        return ResponseEntity.ok(grade);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<GradeMasterDTO> updateGradeMaster(
//            @PathVariable Long id, @RequestBody GradeMasterDTO dto) {
//        GradeMasterDTO updatedGrade = gradeMasterService.updateGradeMaster(id, dto);
//        return ResponseEntity.ok(updatedGrade);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGradeMaster(@PathVariable Long id) {
//        gradeMasterService.deleteGradeMaster(id);
//        return ResponseEntity.noContent().build();
//    }
    @PostMapping
    @Operation(summary = "Create a new Grade", description = "Adds a new Grade.")
    public ResponseEntity<Object> createGradeMaster(@Valid @RequestBody GradeMasterDTO GradeMasterDTO) {
        try {
        	GradeMasterDTO createdTerm = gradeMasterService.createGradeMaster(GradeMasterDTO);
            return ResponseUtil.success("Grade created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<GradeMasterDTO>> getAllGradeMasters() {
        List<GradeMasterDTO> Grades = gradeMasterService.getAllGradeMasters();
        return ResponseEntity.ok(Grades);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get Grade by ID", description = "Fetch a Grade using its unique ID.")
    public ResponseEntity<Object> getGradeMasterById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Gst fetched successfully", gradeMasterService.getGradeMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Grade", description = "Update Grade details based on ID.")
    public ResponseEntity<Object> updatedGrade(@PathVariable Long id, @Valid @RequestBody GradeMasterDTO GradeMasterDTO) {
        try {
            return ResponseUtil.success("Grade updated successfully", gradeMasterService.updateGradeMaster(id, GradeMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Grade", description = "Deletes a Grade by ID.")
    public ResponseEntity<Object> deleteGradeMaster(@PathVariable Long id) {
        try {
        	gradeMasterService.deleteGradeMaster(id);
            return ResponseUtil.success("Grade deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Grade", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}