package com.tech3.erp.controller;

import com.tech3.erp.dto.ProductCategoryDTO;
import com.tech3.erp.service.ProductCategoryService;
import com.tech3.erp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-category")
@Tag(name = "Product Category Controller", description = "APIs for Product Category Management")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping
    @Operation(summary = "Create Product Category")
    public ResponseEntity<Object> createProductCategory(@Valid @RequestBody ProductCategoryDTO dto) {
        try {
            return ResponseUtil.success("Product Category created", productCategoryService.createProductCategory(dto));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Product Category by ID")
    public ResponseEntity<Object> getProductCategoryById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Product Category fetched", productCategoryService.getProductCategoryById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Product Categories")
    public ResponseEntity<Object> getAllProductCategory() {
        return ResponseUtil.success("Product Categories fetched", productCategoryService.getAllProductCategory());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Product Category")
    public ResponseEntity<Object> updateProductCategory(@PathVariable Long id, @Valid @RequestBody ProductCategoryDTO dto) {
        try {
            return ResponseUtil.success("Product Category updated", productCategoryService.updateProductCategory(id, dto));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Product Category")
    public ResponseEntity<Object> deleteProductCategory(@PathVariable Long id) {
        try {
            productCategoryService.deleteProductCategory(id);
            return ResponseUtil.success("Product Category deleted", null);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
