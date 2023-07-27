package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok("Customer " + customerDto.getLogin() + " created successfully!");
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
