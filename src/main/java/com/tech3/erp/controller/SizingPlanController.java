package com.tech3.erp.controller;

import com.tech3.erp.dto.SizingPlanDTO;
import com.tech3.erp.service.SizingPlanService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sizing-plan")
@Tag(name = "Sizing Plan Controller", description = "APIs for Sizing Plan management")

public class SizingPlanController {

	private final SizingPlanService sizingPlanService;

    public SizingPlanController(SizingPlanService sizingPlanService) {
        this.sizingPlanService = sizingPlanService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<SizingPlanDTO> createSizingPlan(@Valid @RequestBody SizingPlanDTO sizingPlanDTO) {
        SizingPlanDTO createdPlan = sizingPlanService.saveSizingPlan(sizingPlanDTO);
        return ResponseEntity.ok(createdPlan);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<SizingPlanDTO>> getAllSizingPlans() {
        List<SizingPlanDTO> plans = sizingPlanService.getAllSizingPlans();
        return ResponseEntity.ok(plans);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<SizingPlanDTO> getSizingPlanById(@PathVariable Long id) {
        SizingPlanDTO plan = sizingPlanService.getSizingPlanById(id);
        return ResponseEntity.ok(plan);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<SizingPlanDTO> updateSizingPlan(
            @PathVariable Long id,
            @Valid @RequestBody SizingPlanDTO sizingPlanDTO) {
        SizingPlanDTO updatedPlan = sizingPlanService.updateSizingPlan(id, sizingPlanDTO);
        return ResponseEntity.ok(updatedPlan);
    }

    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSizingPlan(@PathVariable Long id) {
//        sizingPlanService.deleteSizingPlan(id);
//        return ResponseEntity.noContent().build();
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete SizingPlan", description = "Deletes a SizingPlan by ID.")
    public ResponseEntity<Object> deleteSizingPlan(@PathVariable Long id) {
        try {
        	sizingPlanService.deleteSizingPlan(id);
            return ResponseUtil.success("SizingPlan deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the SizingPlan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
