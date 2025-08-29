package com.tech3.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.FabricDispatchForDyeingDTO;
import com.tech3.erp.service.FabricDispatchForDyeingService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/fabric-dispatch")
@Tag(name = "Fabric Dispatch For Dyeing Controller", description = "APIs for Fabric Dispatch For Dyeing management")
@Validated
public class FabricDispatchForDyeingController {

    @Autowired
    private FabricDispatchForDyeingService service;

    // CREATE
    @PostMapping
    public ResponseEntity<FabricDispatchForDyeingDTO> createDispatch(@RequestBody FabricDispatchForDyeingDTO dto) {
        return ResponseEntity.ok(service.createDispatch(dto));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<FabricDispatchForDyeingDTO>> getAllDispatches() {
        return ResponseEntity.ok(service.getAllDispatches());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<FabricDispatchForDyeingDTO>> getDispatchById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDispatchById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FabricDispatchForDyeingDTO> updateDispatch(@PathVariable Long id, @RequestBody FabricDispatchForDyeingDTO dto) {
        FabricDispatchForDyeingDTO updatedDto = service.updateDispatch(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDispatch(@PathVariable Long id) {
//        return service.deleteDispatch(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Fabric Dispatch", description = "Deletes a Fabric Dispatch by ID.")
    public ResponseEntity<Object> deleteDispatch(@PathVariable Long id) {
        try {
        	service.deleteDispatch(id);
            return ResponseUtil.success("Fabric Dispatch deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Fabric Dispatch", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
