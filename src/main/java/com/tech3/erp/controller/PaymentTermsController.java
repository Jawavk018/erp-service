package com.tech3.erp.controller;

import com.tech3.erp.dto.PaymentTermsDTO;
import com.tech3.erp.service.PaymentTermsService;
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
@RequestMapping("/api/payment-terms")
@Tag(name = "Payment Terms Controller", description = "APIs for Payment Terms management")
@Validated
public class PaymentTermsController {

    private final PaymentTermsService paymentTermsService;

    public PaymentTermsController(PaymentTermsService paymentTermsService) {
        this.paymentTermsService = paymentTermsService;
    }

    @PostMapping
    @Operation(summary = "Create a new Payment Term", description = "Adds a new payment term.")
    public ResponseEntity<Object> createPaymentTerms(@Valid @RequestBody PaymentTermsDTO paymentTermsDTO) {
        try {
            PaymentTermsDTO createdPaymentTerms = paymentTermsService.createPaymentTerms(paymentTermsDTO);
            return ResponseUtil.success("Payment term created successfully", createdPaymentTerms);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Payment Term by ID", description = "Fetch a Payment Term using its unique ID.")
    public ResponseEntity<Object> getPaymentTermsById(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Payment term fetched successfully", paymentTermsService.getPaymentTermsById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Payment Terms", description = "Retrieve a list of all payment terms.")
    public ResponseEntity<Object> getAllPaymentTerms() {
        return ResponseUtil.success("Payment terms fetched successfully", paymentTermsService.getAllPaymentTerms());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Payment Term", description = "Update payment term details based on ID.")
    public ResponseEntity<Object> updatePaymentTerms(@PathVariable Long id, @Valid @RequestBody PaymentTermsDTO paymentTermsDTO) {
        try {
            return ResponseUtil.success("Payment term updated successfully", paymentTermsService.updatePaymentTerms(id, paymentTermsDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Payment Term", description = "Deletes a payment term by ID.")
//    public ResponseEntity<Object> deletePaymentTerms(@PathVariable Long id) {
//        try {
//            paymentTermsService.deletePaymentTerms(id);
//            return ResponseUtil.success("Payment term deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Payment term", description = "Deletes a Payment term by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	paymentTermsService.deletePaymentTerms(id);
            return ResponseUtil.success("Payment term deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Payment term", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
