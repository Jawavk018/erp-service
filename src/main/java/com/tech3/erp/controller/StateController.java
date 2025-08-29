package com.tech3.erp.controller;

import com.tech3.erp.dto.StateDTO;
import com.tech3.erp.service.StateService;
import com.tech3.erp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/state")
@Tag(name = "State Controller", description = "APIs for State management")
@Validated
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @PostMapping
    @Operation(summary = "Create a new State", description = "Adds a new State.")
    public ResponseEntity<Object> createState(@Valid @RequestBody StateDTO stateDTO) {
        try {
            StateDTO createdState = stateService.createState(stateDTO);
            return ResponseUtil.success("State created successfully", createdState);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get State by ID", description = "Fetch a State using its unique ID.")
    public ResponseEntity<Object> getState(@PathVariable Long id) {
        try {
            return ResponseUtil.success("State fetched successfully", stateService.getStateById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all States", description = "Retrieve a list of all States.")
    public ResponseEntity<Object> getAllStates() {
        List<StateDTO> states = stateService.getAllStates();
        return ResponseUtil.success("States fetched successfully", states);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update State", description = "Update State details based on ID.")
    public ResponseEntity<Object> updateState(@PathVariable Long id, @Valid @RequestBody StateDTO stateDTO) {
        try {
            return ResponseUtil.success("State updated successfully", stateService.updateState(id, stateDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete State", description = "Deletes a State by ID.")
//    public ResponseEntity<Object> deleteState(@PathVariable Long id) {
//        try {
//            stateService.deleteState(id);
//            return ResponseUtil.success("State deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete State", description = "Deletes a State by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	stateService.deleteState(id);
            return ResponseUtil.success("State deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
