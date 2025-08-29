package com.tech3.erp.controller;

import com.tech3.erp.dto.GenerateInvoiceDTO;
import com.tech3.erp.service.FabricInspectionService;
import com.tech3.erp.service.GenerateInvoiceService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@Tag(name = "Generate Invoive Controller", description = "APIs for Generate Invoive management")

public class GenerateInvoiceController {	

	private final GenerateInvoiceService generateInvoiceService;
	
	public GenerateInvoiceController(GenerateInvoiceService generateInvoiceService) {
        this.generateInvoiceService = generateInvoiceService;
    }


    @PostMapping
    public ResponseEntity<GenerateInvoiceDTO> createInvoice(@RequestBody GenerateInvoiceDTO dto) {
        GenerateInvoiceDTO createdInvoice = generateInvoiceService.createInvoice(dto);
        return ResponseEntity.ok(createdInvoice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenerateInvoiceDTO> getInvoiceById(@PathVariable Long id) {
        GenerateInvoiceDTO invoice = generateInvoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping
    public ResponseEntity<List<GenerateInvoiceDTO>> getAllInvoices() {
        List<GenerateInvoiceDTO> invoices = generateInvoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenerateInvoiceDTO> updateInvoice(
            @PathVariable Long id, 
            @RequestBody GenerateInvoiceDTO dto) {
        GenerateInvoiceDTO updatedInvoice = generateInvoiceService.updateInvoice(id, dto);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        generateInvoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}