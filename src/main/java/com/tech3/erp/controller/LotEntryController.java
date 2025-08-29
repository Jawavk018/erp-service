package com.tech3.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech3.erp.dto.LotEntryDTO;
import com.tech3.erp.service.LotEntryService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/lot_entry")
@Tag(name = "Lot Entry Controller", description = "APIs for managing Lot Entry")

public class LotEntryController {

    @Autowired
    private LotEntryService lotEntryService;

    @GetMapping
    public List<LotEntryDTO> getAllLotEntries() {
        return lotEntryService.getAllLotEntries();
    }
}