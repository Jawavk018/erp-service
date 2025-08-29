package com.tech3.erp.controller;

import com.tech3.erp.dto.JobworkFabricReceiveDTO;
import com.tech3.erp.entity.JobworkFabricReceive;
import com.tech3.erp.service.JobworkFabricReceiveService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobwork-fabric-receive")
@Tag(name = "Jobwork Fabric Receive Controller", description = "APIs for Jobwork Jobwork Fabric Receive management")

public class JobworkFabricReceiveController {

    @Autowired
    private JobworkFabricReceiveService jobworkFabricReceiveService;

    @PostMapping
    @Operation(summary = "Create Jobwork Fabric Receive", description = "Create a new Jobwork Fabric Receive entry.")
    public ResponseEntity<Object> createJobworkFabricReceive(@Valid @RequestBody JobworkFabricReceiveDTO dto) {
        try {
            JobworkFabricReceive created = jobworkFabricReceiveService.createJobworkFabricReceive(dto);
            return ResponseUtil.success("Jobwork Fabric Receive created successfully", created);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Jobwork Fabric Receives", description = "Get all Jobwork Fabric Receive entries.")
    public ResponseEntity<Object> getAllJobworkFabricReceive() {
        List<JobworkFabricReceive> list = jobworkFabricReceiveService.getAllJobworkFabricReceive();
        return ResponseUtil.success("Jobwork Fabric Receives fetched successfully", list);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Jobwork Fabric Receive by ID", description = "Fetch a Jobwork Fabric Receive by its ID.")
    public ResponseEntity<Object> getJobworkFabricReceiveById(@PathVariable Long id) {
        JobworkFabricReceive receive = jobworkFabricReceiveService.getJobworkFabricReceiveById(id);
        if (receive != null) {
            return ResponseUtil.success("Jobwork Fabric Receive fetched successfully", receive);
        } else {
            return ResponseUtil.error("Jobwork Fabric Receive not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Jobwork Fabric Receive", description = "Update a Jobwork Fabric Receive entry by its ID.")
    public ResponseEntity<Object> updateJobworkFabricReceive(
            @PathVariable Long id,
            @Valid @RequestBody JobworkFabricReceiveDTO dto) {
        try {
            JobworkFabricReceive updated = jobworkFabricReceiveService.updateJobworkFabricReceive(id, dto);
            return ResponseUtil.success("Jobwork Fabric Receive updated successfully", updated);
        } catch (RuntimeException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Jobwork Fabric Receive", description = "Delete a Jobwork Fabric Receive entry by its ID.")
//    public ResponseEntity<Object> deleteJobworkFabricReceive(@PathVariable Long id) {
//        boolean deleted = jobworkFabricReceiveService.deleteJobworkFabricReceive(id);
//        if (deleted) {
//            return ResponseUtil.success("Jobwork Fabric Receive deleted successfully", null);
//        } else {
//            return ResponseUtil.error("Jobwork Fabric Receive not found", HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete JobworkFabricReceive", description = "Deletes a JobworkFabricReceive by ID.")
    public ResponseEntity<Object> deleteJobworkFabricReceive(@PathVariable Long id) {
        try {
        	jobworkFabricReceiveService.deleteJobworkFabricReceive(id);
            return ResponseUtil.success("JobworkFabricReceive deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the JobworkFabricReceive", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
