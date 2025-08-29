package com.tech3.erp.controller;

import com.tech3.erp.dto.PoTypeMasterDTO;
import com.tech3.erp.service.PoTypeMasterService;
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
@RequestMapping("/api/po-type-master")
@Tag(name = "PO Type Master Controller", description = "APIs for PO Type Master management")
@Validated
public class PoTypeMasterController {

    private final PoTypeMasterService poTypeMasterService;

    public PoTypeMasterController(PoTypeMasterService poTypeMasterService) {
        this.poTypeMasterService = poTypeMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new PO Type", description = "Adds a new PO type.")
    public ResponseEntity<Object> createPoType(@Valid @RequestBody PoTypeMasterDTO poTypeDTO) {
        try {
            return ResponseUtil.success("PO Type created successfully", poTypeMasterService.createPoType(poTypeDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get PO Type by ID", description = "Fetch a PO type using its unique ID.")
    public ResponseEntity<Object> getPoTypeById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("PO Type fetched successfully", poTypeMasterService.getPoTypeById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all PO Types", description = "Retrieve a list of all PO types.")
    public ResponseEntity<Object> getAllPoTypes() {
        List<PoTypeMasterDTO> list = poTypeMasterService.getAllPoTypes();
        return ResponseUtil.success("PO Types fetched successfully", list);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update PO Type", description = "Update an existing PO type by ID.")
    public ResponseEntity<Object> updatePoType(@PathVariable Long id, @Valid @RequestBody PoTypeMasterDTO poTypeDTO) {
        try {
            return ResponseUtil.success("PO Type updated successfully", poTypeMasterService.updatePoType(id, poTypeDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete PO Type", description = "Delete a PO type by ID.")
//    public ResponseEntity<Object> deletePoType(@PathVariable Long id) {
//        try {
//            poTypeMasterService.deletePoType(id);
//            return ResponseUtil.success("PO Type deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete PO Type", description = "Deletes a PO Type by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	poTypeMasterService.deletePoType(id);
            return ResponseUtil.success("PO Type deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the PO Type", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
