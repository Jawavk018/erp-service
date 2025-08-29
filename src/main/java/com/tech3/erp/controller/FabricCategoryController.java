package com.tech3.erp.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.FabricCategoryDTO;
import com.tech3.erp.service.FabricCategoryService;
import com.tech3.erp.util.ResponseUtil;

@RestController
@RequestMapping("/api/fabric-category")
@Tag(name = "FabricCategory Controller", description = "APIs for FabricCategory management")
@Validated
public class FabricCategoryController {

    private final FabricCategoryService fabricCategoryService;

    public FabricCategoryController(FabricCategoryService fabricCategoryService) {
        this.fabricCategoryService = fabricCategoryService;
    }

    @PostMapping
    @Operation(summary = "Create a new FabricCategory", description = "Adds a new fabric Category.")
    public ResponseEntity<Object> createFabricCategory(@Valid @RequestBody FabricCategoryDTO fabricCategoryDTO) {
        try {
        	FabricCategoryDTO createdFabricType = fabricCategoryService.createFabricCategory(fabricCategoryDTO);
            return ResponseUtil.success("Fabric type created successfully", createdFabricType);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get FabricCategory by ID", description = "Fetch a FabricCategory using its unique ID.")
    public ResponseEntity<Object> getFabricCategoryById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Fabric type fetched successfully", fabricCategoryService.getFabricCategoryById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all FabricCategory", description = "Retrieve a list of all fabric category.")
    public ResponseEntity<Object> getAllFabricCategory() {
        return ResponseUtil.success("Fabric types fetched successfully", fabricCategoryService.getAllFabricCategory());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update FabricCategory", description = "Update fabric category details based on ID.")
    public ResponseEntity<Object> updateFabricCategory(@PathVariable Long id, @Valid @RequestBody FabricCategoryDTO fabricCategoryDTO) {
        try {
            return ResponseUtil.success("Fabric category updated successfully", fabricCategoryService.updateFabricCategory(id, fabricCategoryDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete FabricCategory", description = "Deletes a fabric category by ID.")
//    public ResponseEntity<Object> deleteFabricCategory(@PathVariable Long id) {
//        try {
//            fabricCategoryService.deleteFabricCategory(id);
//            return ResponseUtil.success("Fabric type deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Fabric Category", description = "Deletes a Fabric Category by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	fabricCategoryService.deleteFabricCategory(id);
            return ResponseUtil.success("Fabric Category deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Fabric Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
