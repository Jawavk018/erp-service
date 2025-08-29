package com.tech3.erp.controller;

import com.tech3.erp.dto.ConsigneeDTO;
import com.tech3.erp.service.ConsigneeService;
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
@RequestMapping("/api/consignee")
@Tag(name = "Consignee Controller", description = "APIs for Consignee management")
public class ConsigneeController {

    private final ConsigneeService consigneeService;

    public ConsigneeController(ConsigneeService consigneeService) {
        this.consigneeService = consigneeService;
    }

    @PostMapping
    @Operation(summary = "Create Consignee")
    public ResponseEntity<Object> create(@Valid @RequestBody ConsigneeDTO dto) {
        return ResponseUtil.success("Consignee created", consigneeService.createConsignee(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Consignee by ID")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        return ResponseUtil.success("Consignee fetched", consigneeService.getConsigneeById(id));
    }

    @GetMapping
    @Operation(summary = "List all Consignee")
    public ResponseEntity<Object> getAll() {
        List<ConsigneeDTO> consignee = consigneeService.getAllConsignee();
        return ResponseUtil.success("Consignee fetched", consignee);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Consignee")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody ConsigneeDTO dto) {
        return ResponseUtil.success("Consignee updated", consigneeService.updateConsignee(id, dto));
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Consignee")
//    public ResponseEntity<Object> delete(@PathVariable Long id) {
//        consigneeService.deleteConsignee(id);
//        return ResponseUtil.success("Consignee deleted", null);
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Consignee", description = "Deletes a Consignee by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	consigneeService.deleteConsignee(id);
            return ResponseUtil.success("Category deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Consignee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
