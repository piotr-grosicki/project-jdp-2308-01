package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.DbService;
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

    private final DbService dbService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = dbService.getAllProducts();
        return ResponseEntity.ok(productMapper.mapToProductDtoList(products));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).get();
        return ResponseEntity.ok(productMapper.mapToProductDto(product));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        dbService.deleteProduct(productId);
        return ResponseEntity.ok("Product ID " + productId + " has been deleted.");
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = dbService.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        dbService.saveProduct(product);
        return ResponseEntity.ok().build();
    }
}
