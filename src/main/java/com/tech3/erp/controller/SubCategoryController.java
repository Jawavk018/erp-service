package com.tech3.erp.controller;

import com.tech3.erp.dto.SubCategoryDTO;
import com.tech3.erp.service.SubCategoryService;
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
@RequestMapping("/api/sub-category")
@Tag(name = "SubCategory Controller", description = "APIs for Sub-Category management")
@Validated
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping
    @Operation(summary = "Create a new Sub-Category", description = "Adds a new sub-category.")
    public ResponseEntity<Object> createSubCategory(@Valid @RequestBody SubCategoryDTO subCategoryDTO) {
        try {
            return ResponseUtil.success("Sub-category created successfully", subCategoryService.createSubCategory(subCategoryDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Sub-Category by ID", description = "Fetch a sub-category using its unique ID.")
    public ResponseEntity<Object> getSubCategoryById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Sub-category fetched successfully", subCategoryService.getSubCategoryById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Sub-Categories", description = "Retrieve a list of all sub-categories.")
    public ResponseEntity<Object> getAllSubCategories() {
        List<SubCategoryDTO> subCategories = subCategoryService.getAllSubCategories();
        return ResponseUtil.success("Sub-categories fetched successfully", subCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSubCategory(@PathVariable Long id, @Valid @RequestBody SubCategoryDTO subCategoryDTO) {
        return ResponseUtil.success("Sub-category updated successfully", subCategoryService.updateSubCategory(id, subCategoryDTO));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteSubCategory(@PathVariable Long id) {
//        subCategoryService.deleteSubCategory(id);
//        return ResponseUtil.success("Sub-category deleted successfully", null);
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete SubCategory", description = "Deletes a SubCategory by ID.")
    public ResponseEntity<Object> deleteSubCategory(@PathVariable Long id) {
        try {
        	subCategoryService.deleteSubCategory(id);
            return ResponseUtil.success("SubCategory deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the SubCategory", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/by-category")
    public List<SubCategoryDTO> getSubCategoriesByCategoryName(@RequestParam String categoryName) {
        return subCategoryService.getSubCategoriesByCategoryName(categoryName);
    }
    
}
