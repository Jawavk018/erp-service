package com.tech3.erp.controller;

import com.tech3.erp.dto.CountryDTO;
import com.tech3.erp.service.CountryService;
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
@RequestMapping("/api/country")
@Tag(name = "Country Controller", description = "APIs for user management")
@Validated
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    @Operation(summary = "Create a new Country", description = "Adds a new Country.")
    public ResponseEntity<Object> createCountry(@Valid @RequestBody CountryDTO countryDTO) {
        try {
            CountryDTO createCountry = countryService.createCountry(countryDTO);
            return ResponseUtil.success("Country created successfully", createCountry);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Country by ID", description = "Fetch a Country using their unique ID.")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        try {
            return ResponseUtil.success("Country fetched successfully", countryService.getCountryById(id));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all Countries", description = "Retrieve a list of all Countries.")
    public ResponseEntity<Object> getAllCountries() {
        return ResponseUtil.success("Countries fetched successfully", countryService.getAllCountries());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Country", description = "Update Country details based on ID.")
    public ResponseEntity<Object> updateCountry(@PathVariable Long id, @Valid @RequestBody CountryDTO countryDTO) {
        try {
            return ResponseUtil.success("Country updated successfully", countryService.updateCountry(id, countryDTO));
        } catch (IllegalArgumentException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Country", description = "Deletes a Country by ID.")
//    public ResponseEntity<Object> deleteCountry(@PathVariable Long id) {
//        try {
//            countryService.deleteCountry(id);
//            return ResponseUtil.success("Country deleted successfully", null);
//        } catch (IllegalArgumentException e) {
//            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Country", description = "Deletes a Country by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	countryService.deleteCountry(id);
            return ResponseUtil.success("Country deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Country", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
