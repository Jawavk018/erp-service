package com.tech3.erp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.EmptyBeamIssueDTO;
import com.tech3.erp.service.EmptyBeamIssueService;

import java.util.List;

@RestController
@RequestMapping("/api/empty_beam_issue")
@Tag(name = "Empty Beam Issue Controller", description = "APIs for Empty Beam Issue management")
public class EmptyBeamIssueController {

    private final EmptyBeamIssueService emptyBeamIssueService;

    public EmptyBeamIssueController(EmptyBeamIssueService emptyBeamIssueService) {
        this.emptyBeamIssueService = emptyBeamIssueService;
    }

    // CREATE
    @PostMapping
    @Operation(summary = "Create a new EmptyBeamIssue", description = "Add a new EmptyBeamIssue.")
    public ResponseEntity<EmptyBeamIssueDTO> createEmptyBeamIssue(@RequestBody @Valid EmptyBeamIssueDTO dto) {
    	EmptyBeamIssueDTO saved = emptyBeamIssueService.saveEmptyBeamIssue(dto);
        return ResponseEntity.ok(saved);
    }

    // READ ALL
    @GetMapping
    @Operation(summary = "Get all EmptyBeamIssues", description = "Retrieve a list of all EmptyBeamIssues.")
    public ResponseEntity<List<EmptyBeamIssueDTO>> getAllEmptyBeamIssues() {
        return ResponseEntity.ok(emptyBeamIssueService.getAllEmptyBeamIssues());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmptyBeamIssueDTO> getEmptyBeamIssueById(@PathVariable Long id) {
        return ResponseEntity.ok(emptyBeamIssueService.getEmptyBeamIssueById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmptyBeamIssueDTO> updateEmptyBeamIssue(@PathVariable Long id, @RequestBody @Valid EmptyBeamIssueDTO dto) {
    	EmptyBeamIssueDTO updated = emptyBeamIssueService.updateEmptyBeamIssue(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmptyBeamIssue(@PathVariable Long id) {
    	emptyBeamIssueService.deleteEmptyBeamIssue(id);
        return ResponseEntity.noContent().build();
    }
}

