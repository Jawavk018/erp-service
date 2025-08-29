package com.tech3.erp.controller;

import com.tech3.erp.dto.CityDTO;
import com.tech3.erp.dto.StateDTO;
import com.tech3.erp.service.CityService;
import com.tech3.erp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@Tag(name = "City Controller", description = "APIs for City management")
@Validated
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    @Operation(summary = "Create a new City", description = "Adds a new City.")
    public ResponseEntity<Object> createCity(@Valid @RequestBody CityDTO cityDTO) {
        try {
            CityDTO createCity = cityService.createCity(cityDTO);
            return ResponseUtil.success("City created successfully", createCity);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
   
    @GetMapping("/{id}")
    @Operation(summary = "Get City by ID", description = "Fetch a City using its unique ID.")
    public ResponseEntity<Object> getCity(@PathVariable Long id) {
        return ResponseUtil.success("City fetched successfully", cityService.getCityById(id));
    }

    @GetMapping
    @Operation(summary = "Get all Cities", description = "Retrieve a paginated list of all Cities.")
    public ResponseEntity<Object> getAllCities() {
    	List<CityDTO> cities = cityService.getAllCities();
        return ResponseUtil.success("Cities fetched successfully", cities);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update City", description = "Update an existing City.")
    public ResponseEntity<Object> updateCity(@PathVariable Long id, @Valid @RequestBody CityDTO cityDTO) {
        return ResponseUtil.success("City updated successfully", cityService.updateCity(id, cityDTO));
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete City", description = "Delete a City by ID.")
//    public ResponseEntity<Object> deleteCity(@PathVariable Long id) {
//        cityService.deleteCity(id);
//        return ResponseUtil.success("City deleted successfully", null);
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete City", description = "Deletes a City by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	cityService.deleteCity(id);
            return ResponseUtil.success("Category deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
