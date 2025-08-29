package com.tech3.erp.controller;

import com.tech3.erp.dto.PurchaseOrderDTO;
import com.tech3.erp.dto.VendorDTO;
import com.tech3.erp.service.PurchaseOrderService;
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
@RequestMapping("/api/purchase-orders")
@Tag(name = "Purchase Order Controller", description = "APIs for managing Purchase Orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    // Constructor injection
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping
    @Operation(summary = "Create Purchase Order", description = "Creates a new Purchase Order with items")
    public ResponseEntity<Object> create(@Valid @RequestBody PurchaseOrderDTO dto) {
        try {
            PurchaseOrderDTO created = purchaseOrderService.createPurchaseOrder(dto);
            return ResponseUtil.success("Purchase Order created successfully", created);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Purchase Order by ID", description = "Fetch a Purchase Order by its ID")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            PurchaseOrderDTO order = purchaseOrderService.getPurchaseOrderById(id);
            return ResponseUtil.success("Purchase Order fetched successfully", order);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "List all Purchase Orders", description = "Returns all Purchase Orders")
    public ResponseEntity<Object> getAll() {
        List<PurchaseOrderDTO> list = purchaseOrderService.getAllPurchaseOrders();
        return ResponseUtil.success("Purchase Orders fetched successfully", list);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Purchase Order", description = "Updates an existing Purchase Order by ID")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody PurchaseOrderDTO dto) {
        try {
            PurchaseOrderDTO updated = purchaseOrderService.updatePurchaseOrder(id, dto);
            return ResponseUtil.success("Purchase Order updated successfully", updated);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Purchase Order", description = "Deletes a Purchase Order by its ID")
//    public ResponseEntity<Object> delete(@PathVariable Long id) {
//        try {
//            purchaseOrderService.deletePurchaseOrder(id);
//            return ResponseUtil.success("Purchase Order deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Purchase Order", description = "Deletes a Purchase Order by ID.")
    public ResponseEntity<Object> deletePurchaseOrder(@PathVariable Long id) {
        try {
        	purchaseOrderService.deletePurchaseOrder(id);
            return ResponseUtil.success("Purchase Order deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Purchase Order", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/vendor/{vendorId}")
    @Operation(summary = "Get Purchase Order by Vendor ID", description = "Fetch Purchase Orders by Vendor ID")
    public ResponseEntity<Object> getPurchaseOrderByVendorId(@PathVariable Long vendorId) {
        try {
            List<PurchaseOrderDTO> orders = purchaseOrderService.getPurchaseOrdersByVendorId(vendorId); // should return list if many
            return ResponseUtil.success("Purchase Orders fetched successfully", orders);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/vendors-by-po-type/{poTypeId}")
    public ResponseEntity<List<VendorDTO>> getVendorsByPoType(@PathVariable Long poTypeId) {
        return ResponseEntity.ok(purchaseOrderService.getVendorsByPoType(poTypeId));
    }


}

