package com.tech3.erp.controller;

import com.tech3.erp.dto.YarnMasterDTO;
import com.tech3.erp.service.YarnMasterService;
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
@RequestMapping("/api/yarn")
@Tag(name = "Yarn Master Controller", description = "APIs for Yarn Master management")
@Validated
public class YarnMasterController {

    private final YarnMasterService yarnMasterService;

    public YarnMasterController(YarnMasterService yarnMasterService) {
        this.yarnMasterService = yarnMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Yarn Master", description = "Adds a new Yarn Master entry.")
    public ResponseEntity<Object> createYarnMaster(@Valid @RequestBody YarnMasterDTO yarnMasterDTO) {
        try {
            YarnMasterDTO createdYarn = yarnMasterService.createYarnMaster(yarnMasterDTO);
            return ResponseUtil.success("Yarn created successfully", createdYarn);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Yarn Master by ID", description = "Fetch a Yarn Master entry using its unique ID.")
    public ResponseEntity<Object> getYarn(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Yarn fetched successfully", yarnMasterService.getYarnMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Yarn Masters", description = "Retrieve a list of all Yarn Masters.")
    public ResponseEntity<Object> getAllYarnMasters() {
        List<YarnMasterDTO> yarns = yarnMasterService.getAllYarnMasters();
        return ResponseUtil.success("Yarns fetched successfully", yarns);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Yarn Master", description = "Update Yarn Master details based on ID.")
    public ResponseEntity<Object> updateYarnMaster(@PathVariable Long id, @Valid @RequestBody YarnMasterDTO yarnMasterDTO) {
        try {
            return ResponseUtil.success("Yarn updated successfully", yarnMasterService.updateYarnMaster(id, yarnMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Yarn Master", description = "Deletes a Yarn Master by ID.")
//    public ResponseEntity<Object> deleteYarnMaster(@PathVariable Long id) {
//        try {
//            yarnMasterService.deleteYarnMaster(id);
//            return ResponseUtil.success("Yarn deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Yarn", description = "Deletes a Yarn by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	yarnMasterService.deleteYarnMaster(id);
            return ResponseUtil.success("Yarn deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Yarn", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
