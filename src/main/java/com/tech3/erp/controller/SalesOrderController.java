package com.tech3.erp.controller;

import com.tech3.erp.dto.SalesOrderDTO;
import com.tech3.erp.service.SalesOrderService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
@Tag(name = "Sales Order Controller", description = "APIs for Sales Order management")
public class SalesOrderController {

    private final SalesOrderService salesOrderService;

    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    // CREATE
//    @PostMapping
//    @Operation(summary = "Create a new Sales Order", description = "Add a new Sales Order.")
//    public ResponseEntity<SalesOrderDTO> createSalesOrder(@RequestBody @Valid SalesOrderDTO dto) {
//        SalesOrderDTO saved = salesOrderService.saveSalesOrder(dto);
//        return ResponseEntity.ok(saved);
//    }
    @PostMapping
    @Operation(summary = "Create a new Sales Order", description = "Adds a new Sales Order.")
    public ResponseEntity<Object> createSalesOrder(@Valid @RequestBody SalesOrderDTO salesOrderDTO) {
        try {
        	SalesOrderDTO createSalesOrder = salesOrderService.saveSalesOrder(salesOrderDTO);
            return ResponseUtil.success("Sales Order created successfully", createSalesOrder);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // READ ALL
    @GetMapping
    @Operation(summary = "Get all Sales Orders", description = "Retrieve a list of all Sales Orders.")
    public ResponseEntity<List<SalesOrderDTO>> getAllSalesOrders() {
        return ResponseEntity.ok(salesOrderService.getAllSalesOrders());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<SalesOrderDTO> getSalesOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(salesOrderService.getSalesOrderById(id));
    }

    // UPDATE
//    @PutMapping("/{id}")
//    public ResponseEntity<SalesOrderDTO> updateSalesOrder(@PathVariable Long id, @RequestBody @Valid SalesOrderDTO dto) {
//        SalesOrderDTO updated = salesOrderService.updateSalesOrder(id, dto);
//        return ResponseEntity.ok(updated);
//    }
    @PutMapping("/{id}")
    @Operation(summary = "Update Sales Orders", description = "Update Sales Orders details based on ID.")
    public ResponseEntity<Object> updateSalesOrder(@PathVariable Long id, @Valid @RequestBody SalesOrderDTO salesOrderDTO) {
        try {
            return ResponseUtil.success("Sales Orders updated successfully", salesOrderService.updateSalesOrder(id, salesOrderDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSalesOrder(@PathVariable Long id) {
//        salesOrderService.deleteSalesOrder(id);
//        return ResponseEntity.noContent().build();
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Sales Order", description = "Deletes a Sales Order by ID.")
    public ResponseEntity<Object> deleteSalesOrder(@PathVariable Long id) {
        try {
        	salesOrderService.deleteSalesOrder(id);
            return ResponseUtil.success("Sales Order deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Sales Order", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<SalesOrderDTO>> getSalesOrdersByCustomerId(@PathVariable Long customerId) {
        try {
            List<SalesOrderDTO> orders = salesOrderService.getSalesOrdersByCustomerId(customerId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

