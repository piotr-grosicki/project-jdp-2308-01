package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<String> getProduct(@PathVariable Long productId) {
            return ResponseEntity.ok("Product " + productId);
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        System.out.println("Product with ID " + productId + " has been deleted");
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok("Product " + productDto.getName() + " has been updated");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok("Procudt " + productDto.getName() + " created succesfully!");
    }
}
