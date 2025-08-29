package com.tech3.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech3.erp.dto.GeneratePackingDTO;
import com.tech3.erp.service.GeneratePackingService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/generate-packing")
@Tag(name = "Generate Packing Controller", description = "APIs for Generate Packing management")
public class GeneratePackingController {

    private final GeneratePackingService generatePackingService;

    @Autowired
    public GeneratePackingController(GeneratePackingService generatePackingService) {
        this.generatePackingService = generatePackingService;
    }

    @PostMapping
    @Operation(summary = "Create a new Packing List", description = "Adds a new Packing List.")
    public ResponseEntity<Object> createGeneratePacking(@Valid @RequestBody GeneratePackingDTO generatePackingDTO) {
        try {
        	GeneratePackingDTO createGeneratePacking = generatePackingService.createGeneratePacking(generatePackingDTO);
            return ResponseUtil.success("Packing List created successfully", createGeneratePacking);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GeneratePackingDTO> getGeneratePackingById(@PathVariable Long id) {
        GeneratePackingDTO generatePackingDTO = generatePackingService.getGeneratePackingById(id);
        return ResponseEntity.ok(generatePackingDTO);
    }

    @GetMapping
    public ResponseEntity<List<GeneratePackingDTO>> getAllGeneratePackings() {
        List<GeneratePackingDTO> generatePackings = generatePackingService.getAllGeneratePackings();
        return ResponseEntity.ok(generatePackings);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update Packing List", description = "Update Packing List details based on ID.")
    public ResponseEntity<Object> updateGeneratePacking(@PathVariable Long id, @Valid @RequestBody GeneratePackingDTO generatePackingDTO) {
        try {
            return ResponseUtil.success("Packing List updated successfully", generatePackingService.updateGeneratePacking(id, generatePackingDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGeneratePacking(@PathVariable Long id) {
//        generatePackingService.deleteGeneratePacking(id);
//        return ResponseEntity.noContent().build();
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Packing List", description = "Deletes a Packing List by ID.")
    public ResponseEntity<Object> deleteGeneratePacking(@PathVariable Long id) {
        try {
        	generatePackingService.deleteGeneratePacking(id);
            return ResponseUtil.success("Packing List deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Packing List", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
