package com.tech3.erp.controller;

import com.tech3.erp.dto.CustomerDTO;
import com.tech3.erp.service.CustomerService;
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
@RequestMapping("/api/customer")
@Tag(name = "Customer Controller", description = "APIs for Customer management")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @Operation(summary = "Create Customer")
    public ResponseEntity<Object> create(@Valid @RequestBody CustomerDTO dto) {
        return ResponseUtil.success("Customer created", customerService.createCustomer(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Customer by ID")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        return ResponseUtil.success("Customer fetched", customerService.getCustomerById(id));
    }

    @GetMapping
    @Operation(summary = "List all Customers")
    public ResponseEntity<Object> getAll() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseUtil.success("Customers fetched", customers);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Customer")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody CustomerDTO dto) {
        return ResponseUtil.success("Customer updated", customerService.updateCustomer(id, dto));
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete Customer")
//    public ResponseEntity<Object> delete(@PathVariable Long id) {
//        customerService.deleteCustomer(id);
//        return ResponseUtil.success("Customer deleted", null);
//    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Customer", description = "Deletes a Customer by ID.")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
        	customerService.deleteCustomer(id);
            return ResponseUtil.success("Customer deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return ResponseUtil.error(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseUtil.error("An error occurred while deleting the Customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
