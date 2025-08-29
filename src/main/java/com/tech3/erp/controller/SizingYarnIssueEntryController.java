package com.tech3.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.SizingYarnIssueEntryDTO;
import com.tech3.erp.service.SizingYarnIssueEntryService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/sizing-yarn-issues")
@Tag(name = "Sizing Yarn Issues", description = "APIs for Sizing Yarn Issues management")

public class SizingYarnIssueEntryController {

    @Autowired
    private SizingYarnIssueEntryService service;

    @GetMapping
    public ResponseEntity<List<SizingYarnIssueEntryDTO>> getAllSizingYarnIssueEntrys() {
        List<SizingYarnIssueEntryDTO> issues = service.getAllSizingYarnIssueEntrys();
        return ResponseEntity.ok(issues);
    }

    @PostMapping
    public ResponseEntity<SizingYarnIssueEntryDTO> createSizingYarnIssueEntry(@RequestBody SizingYarnIssueEntryDTO dto) {
    	SizingYarnIssueEntryDTO createdIssue = service.createSizingYarnIssueEntry(dto);
        return ResponseEntity.ok(createdIssue);
    }

    // You can uncomment and use this if you need a separate endpoint for creating with requirements
    /*
    @PostMapping("/with-requirements")
    public ResponseEntity<SizingYarnIssueEntryDTO> createWithRequirements(
            @RequestBody SizingYarnIssueEntryDTO dto) {
        SizingYarnIssueEntryDTO createdIssue = service.createWeavingYarnIssue(dto);
        return ResponseEntity.ok(createdIssue);
    }
    */
}