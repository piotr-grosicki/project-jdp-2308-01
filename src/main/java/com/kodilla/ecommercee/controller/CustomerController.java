package com.kodilla.ecommercee.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody String customerDto) {
        return ResponseEntity.ok("Customer created successfully!");
    }

    @PutMapping(value = "{customerId}/block")
    public ResponseEntity<String> blockCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok("Customer with ID " + customerId + " has been blocked");
    }

    @PutMapping(value = "{customerId}/genKey")
    public ResponseEntity<String> generateCustomerKey(@PathVariable Long customerId) {
        return ResponseEntity.ok("New password for customer ID " + customerId + " is: password");
    }

}
