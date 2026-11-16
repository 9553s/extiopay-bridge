
package com.extio.pay.controller;

import com.extio.pay.dto.CustomerRequest;
import com.extio.pay.dto.CustomerResponse;
import com.extio.pay.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create customer
    @PostMapping
    public CustomerResponse createCustomer(
            @RequestBody CustomerRequest request) {

        return customerService.saveCustomer(request);
    }

    // Get all customers
    @GetMapping
    public List<CustomerResponse> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(
            @PathVariable Long id) {

        try {
            return ResponseEntity.ok(
                    customerService.getCustomerById(id)
            );

        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    // Update customer
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequest request) {

        try {
            return ResponseEntity.ok(
                    customerService.updateCustomer(id, request)
            );

        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable Long id) {

        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
