package com.tech3.erp.controller;

import com.tech3.erp.dto.TermsConditionsDTO;
import com.tech3.erp.service.TermsConditionsService;
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
@RequestMapping("/api/terms-conditions")
@Tag(name = "Terms & Conditions Controller", description = "APIs for Terms & Conditions management")
@Validated
public class TermsConditionsController {

    private final TermsConditionsService service;

    public TermsConditionsController(TermsConditionsService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new Terms & Conditions entry")
    public ResponseEntity<Object> create(@Valid @RequestBody TermsConditionsDTO dto) {
        try {
            return ResponseUtil.success("Created successfully", service.createTermsCondition(dto));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Terms & Conditions by ID")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Fetched successfully", service.getTermsConditionById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Terms & Conditions")
    public ResponseEntity<Object> getAll() {
        return ResponseUtil.success("Fetched all successfully", service.getAllTermsConditions());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Terms & Conditions")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody TermsConditionsDTO dto) {
        try {
            return ResponseUtil.success("Updated successfully", service.updateTermsCondition(id, dto));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Terms & Conditions")
//    public ResponseEntity<Object> delete(@PathVariable Long id) {
//        try {
//            service.deleteTermsCondition(id);
//            return ResponseUtil.success("Deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Terms & Conditions", description = "Deletes a Terms & Conditions by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	service.deleteTermsCondition(id);
            return ResponseUtil.success("Terms & Conditions deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Terms & Conditions", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

