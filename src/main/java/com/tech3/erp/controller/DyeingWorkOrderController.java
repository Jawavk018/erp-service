package com.tech3.erp.controller;

import com.tech3.erp.dto.DyeingWorkOrderDTO;
import com.tech3.erp.service.DyeingWorkOrderService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dyeing-work-orders")
@Tag(name = "Dyeing Work Order Controller", description = "APIs for Dyeing Work Order management")
public class DyeingWorkOrderController {

    @Autowired
    private DyeingWorkOrderService dyeingWorkOrderService;

    @PostMapping
    @Operation(summary = "Create Dyeing Work Order")
    public ResponseEntity<Object> createDyeingWorkOrder(@Valid @RequestBody DyeingWorkOrderDTO dto) {
        DyeingWorkOrderDTO created = dyeingWorkOrderService.createDyeingWorkOrder(dto);
        return ResponseUtil.success("Dyeing Work Order created successfully", created);
    }

    @GetMapping
    @Operation(summary = "Get all Dyeing Work Orders")
    public ResponseEntity<Object> getAllDyeingWorkOrders() {
        List<DyeingWorkOrderDTO> list = dyeingWorkOrderService.getAllDyeingWorkOrders();
        return ResponseUtil.success("Dyeing Work Orders fetched successfully", list);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Dyeing Work Order by ID")
    public ResponseEntity<Object> getDyeingWorkOrderById(@PathVariable Long id) {
        DyeingWorkOrderDTO dto = dyeingWorkOrderService.getDyeingWorkOrderById(id);
        if (dto != null) {
            return ResponseUtil.success("Dyeing Work Order fetched successfully", dto);
        } else {
            return ResponseUtil.error("Dyeing Work Order not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Dyeing Work Order")
    public ResponseEntity<Object> updateDyeingWorkOrder(@PathVariable Long id, @Valid @RequestBody DyeingWorkOrderDTO dto) {
        try {
            DyeingWorkOrderDTO updated = dyeingWorkOrderService.updateDyeingWorkOrder(id, dto);
            return ResponseUtil.success("Dyeing Work Order updated successfully", updated);
        } catch (RuntimeException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Dyeing Work Order")
    public ResponseEntity<Object> deleteDyeingWorkOrder(@PathVariable Long id) {
        boolean deleted = dyeingWorkOrderService.deleteDyeingWorkOrder(id);
        if (deleted) {
            return ResponseUtil.success("Dyeing Work Order deleted successfully", null);
        } else {
            return ResponseUtil.error("Dyeing Work Order not found", HttpStatus.NOT_FOUND);
        }
    }
}
