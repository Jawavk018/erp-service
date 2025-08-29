package com.tech3.erp.controller;

import com.tech3.erp.dto.PurchaseInwardDTO;
import com.tech3.erp.entity.PurchaseInward;
import com.tech3.erp.service.PurchaseInwardService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-inward")
@Tag(name = "Purchase Inward Controller", description = "APIs for Purchase Inward management")
@CrossOrigin(origins = "*")
public class PurchaseInwardController {

    @Autowired
    private PurchaseInwardService inwardService;

    // Create a new purchase inward entry
    @PostMapping
    public ResponseEntity<?> createPurchaseInward(@RequestBody PurchaseInwardDTO requestDTO) {
        try {
            PurchaseInward savedInward = inwardService.createPurchaseInward(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedInward);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while saving Purchase Inward: " + e.getMessage());
        }
    }

    // Get all purchase inwards
    @GetMapping
    public ResponseEntity<List<PurchaseInward>> getAllPurchaseInwards() {
        List<PurchaseInward> inwards = inwardService.getAllPurchaseInwards();
        return ResponseEntity.ok(inwards);
    }

    // Get a purchase inward by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseInwardById(@PathVariable Long id) {
        try {
            PurchaseInward inward = inwardService.getPurchaseInwardById(id);
            if (inward != null) {
                return ResponseEntity.ok(inward);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase Inward not found for ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    // Delete a purchase inward by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deletePurchaseInward(@PathVariable Long id) {
//        try {
//            boolean deleted = inwardService.deletePurchaseInward(id);
//            if (deleted) {
//                return ResponseEntity.ok("Purchase Inward deleted successfully.");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase Inward not found for ID: " + id);
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Purchase Inward", description = "Deletes a Purchase Inward by ID.")
    public ResponseEntity<Object> deleteSizingPlan(@PathVariable Long id) {
        try {
        	inwardService.deletePurchaseInward(id);
            return ResponseUtil.success("Purchase Inward deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Purchase Inward", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Health check endpoint
    @GetMapping("/ping")
    public String ping() {
        return "Purchase Inward API is working!";
    }
}
