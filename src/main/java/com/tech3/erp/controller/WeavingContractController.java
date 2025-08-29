package com.tech3.erp.controller;

import com.tech3.erp.dto.WeavingContractDTO;
import com.tech3.erp.entity.WeavingContract;
import com.tech3.erp.service.WeavingContractService;
import com.tech3.erp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weaving-contracts")
@Tag(name = "Weaving Contracts Controller", description = "APIs for Weaving Contracts management")


public class WeavingContractController {

    @Autowired
    private WeavingContractService contractService;

    @PostMapping
    public ResponseEntity<?> createWeavingContract(@RequestBody WeavingContractDTO dto) {
        WeavingContract saved = contractService.createWeavingContract(dto);
        return ResponseEntity.ok(saved);
    }

     @Operation(summary = "Get all weaving contracts")
     @GetMapping
     public ResponseEntity<List<WeavingContract>> getAllWeavingContract() {
         List<WeavingContract> list = contractService.getAllWeavingContract();
         return ResponseEntity.ok(list);
     }

    @Operation(summary = "Get weaving contract by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getWeavingContractById(@PathVariable Long id) {
        WeavingContract contract = contractService.getWeavingContractById(id);
        return ResponseEntity.ok(contract);
    }

//    @Operation(summary = "Delete weaving contract by ID")
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteContract(@PathVariable Long id) {
//        contractService.deleteContract(id);
//        return ResponseEntity.ok("Contract deleted successfully with ID: " + id);
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Weaving Contract", description = "Deletes a Weaving Contract by ID.")
    public ResponseEntity<Object> deleteWeavingContract(@PathVariable Long id) {
        try {
        	contractService.deleteWeavingContract(id);
            return ResponseUtil.success("Weaving Contract deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Weaving Contract", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @Operation(summary = "Update weaving contract by ID")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWeavingContract(@PathVariable Long id, @RequestBody WeavingContractDTO dto) {
        WeavingContract updated = contractService.updateWeavingContract(id, dto);
        return ResponseEntity.ok(updated);
    }
}
