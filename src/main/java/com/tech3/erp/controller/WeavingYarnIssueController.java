package com.tech3.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.WeavingYarnIssueDTO;
import com.tech3.erp.service.WeavingYarnIssueService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/weaving-yarn-issues")
@Tag(name = "Weaving Yarn Issues", description = "APIs for Weaving Yarn Issues management")

public class WeavingYarnIssueController {

    @Autowired
    private WeavingYarnIssueService service;

    @GetMapping
    public ResponseEntity<List<WeavingYarnIssueDTO>> getAllWeavingYarnIssues() {
        List<WeavingYarnIssueDTO> issues = service.getAllWeavingYarnIssues();
        return ResponseEntity.ok(issues);
    }

    @PostMapping
    public ResponseEntity<WeavingYarnIssueDTO> createWeavingYarnIssue(@RequestBody WeavingYarnIssueDTO dto) {
        WeavingYarnIssueDTO createdIssue = service.createWeavingYarnIssue(dto);
        return ResponseEntity.ok(createdIssue);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing weaving yarn issue")
    public ResponseEntity<WeavingYarnIssueDTO> updateWeavingYarnIssue(
            @PathVariable Long id,
            @RequestBody WeavingYarnIssueDTO dto) {
        WeavingYarnIssueDTO updatedIssue = service.updateWeavingYarnIssue(id, dto);
        return ResponseEntity.ok(updatedIssue);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a weaving yarn issue")
    public ResponseEntity<Void> deleteWeavingYarnIssue(@PathVariable Long id) {
        service.deleteWeavingYarnIssue(id);
        return ResponseEntity.noContent().build();
    }

    // You can uncomment and use this if you need a separate endpoint for creating with requirements
    /*
    @PostMapping("/with-requirements")
    public ResponseEntity<WeavingYarnIssueDTO> createWithRequirements(
            @RequestBody WeavingYarnIssueDTO dto) {
        WeavingYarnIssueDTO createdIssue = service.createWeavingYarnIssue(dto);
        return ResponseEntity.ok(createdIssue);
    }
    */
}