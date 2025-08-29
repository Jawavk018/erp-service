package com.tech3.erp.controller;

import com.tech3.erp.dto.CategoryDTO;
import com.tech3.erp.service.CategoryService;
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
@RequestMapping("/api/category")
@Tag(name = "Category Controller", description = "APIs for Category management")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @Operation(summary = "Create a new Category", description = "Adds a new category.")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
            return ResponseUtil.success("Category created successfully", createdCategory);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Category by ID", description = "Fetch a Category using its unique ID.")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Category fetched successfully", categoryService.getCategoryById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Categories", description = "Retrieve a list of all categories.")
    public ResponseEntity<Object> getAllCategories() {
        return ResponseUtil.success("Categories fetched successfully", categoryService.getAllCategories());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Category", description = "Update category details based on ID.")
    public ResponseEntity<Object> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            return ResponseUtil.success("Category updated successfully", categoryService.updateCategory(id, categoryDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Category", description = "Deletes a category by ID.")
//    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
//        try {
//            categoryService.deleteCategory(id);
//            return ResponseUtil.success("Category deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Category", description = "Deletes a category by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseUtil.success("Category deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
