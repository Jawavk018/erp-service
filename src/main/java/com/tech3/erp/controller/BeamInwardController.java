package com.tech3.erp.controller;

import com.tech3.erp.dto.BeamInwardDTO;
import com.tech3.erp.service.BeamInwardService;
import com.tech3.erp.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beam-inward")
@Tag(name = "Beam Inward Controller", description = "APIs for Beam Inward management")

public class BeamInwardController {

	private final BeamInwardService beamInwardService;

    public BeamInwardController(BeamInwardService beamInwardService) {
        this.beamInwardService = beamInwardService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<BeamInwardDTO> createBeamInward(@Valid @RequestBody BeamInwardDTO beamInwardDTO) {
    	BeamInwardDTO createdPlan = beamInwardService.saveBeamInward(beamInwardDTO);
        return ResponseEntity.ok(createdPlan);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<BeamInwardDTO>> getAllBeamInward() {
        List<BeamInwardDTO> plans = beamInwardService.getAllBeamInward();
        return ResponseEntity.ok(plans);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<BeamInwardDTO> getBeamInwardById(@PathVariable Long id) {
    	BeamInwardDTO plan = beamInwardService.getBeamInwardById(id);
        return ResponseEntity.ok(plan);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<BeamInwardDTO> updateBeamInward(
            @PathVariable Long id,
            @Valid @RequestBody BeamInwardDTO BeamInwardDTO) {
    	BeamInwardDTO updatedPlan = beamInwardService.updateBeamInward(id, BeamInwardDTO);
        return ResponseEntity.ok(updatedPlan);
    }

    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSizingPlan(@PathVariable Long id) {
//        beamInwardService.deleteSizingPlan(id);
//        return ResponseEntity.noContent().build();
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Beam Inward", description = "Deletes a Beam Inward by ID.")
    public ResponseEntity<Object> deleteBeamInward(@PathVariable Long id) {
        try {
        	beamInwardService.deleteBeamInward(id);
            return ResponseUtil.success("Beam Inward deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Beam Inward", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
