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

import com.tech3.erp.dto.ProcessMasterDTO;
import com.tech3.erp.service.ProcessMasterService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/process")
@Tag(name = "Process Master Controller", description = "APIs for Process Master management")
public class ProcessMasterController {
	
	private final ProcessMasterService processMasterService;

    @Autowired
    public ProcessMasterController(ProcessMasterService processMasterService) {
        this.processMasterService = processMasterService;
    }

    @PostMapping
    @Operation(summary = "Create a new Process", description = "Adds a new Process.")
    public ResponseEntity<Object> createProcessMaster(@Valid @RequestBody ProcessMasterDTO processMasterDTO) {
        try {
        	ProcessMasterDTO createdTerm = processMasterService.createProcessMaster(processMasterDTO);
            return ResponseUtil.success("Process created successfully", createdTerm);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProcessMasterDTO>> getAllProcessMasters() {
        List<ProcessMasterDTO> process = processMasterService.getAllProcessMasters();
        return ResponseEntity.ok(process);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get Process by ID", description = "Fetch a Process using its unique ID.")
    public ResponseEntity<Object> getProcessMasterById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Gst fetched successfully", processMasterService.getProcessMasterById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Process", description = "Update Process details based on ID.")
    public ResponseEntity<Object> updatedProcess(@PathVariable Long id, @Valid @RequestBody ProcessMasterDTO processMasterDTO) {
        try {
            return ResponseUtil.success("Process updated successfully", processMasterService.updateProcessMaster(id, processMasterDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Process", description = "Deletes a Process by ID.")
    public ResponseEntity<Object> deleteProcessMaster(@PathVariable Long id) {
        try {
        	processMasterService.deleteProcessMaster(id);
            return ResponseUtil.success("Process deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Process", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

}
