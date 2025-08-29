package com.tech3.erp.controller;

import com.tech3.erp.dto.AddressDTO;
import com.tech3.erp.service.AddressService;
import com.tech3.erp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@Tag(name = "Address Controller", description = "APIs for Address management")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    @Operation(summary = "Create Address")
    public ResponseEntity<Object> create(@Valid @RequestBody AddressDTO dto) {
        return ResponseUtil.success("Address created", addressService.createAddress(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Address by ID")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        return ResponseUtil.success("Address fetched", addressService.getAddressById(id));
    }

    @GetMapping
    @Operation(summary = "List all Addresses")
    public ResponseEntity<Object> getAll() {
        List<AddressDTO> addresses = addressService.getAllAddresses();
        return ResponseUtil.success("Addresses fetched", addresses);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Address")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody AddressDTO dto) {
        return ResponseUtil.success("Address updated", addressService.updateAddress(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Address")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseUtil.success("Address deleted", null);
    }
}

