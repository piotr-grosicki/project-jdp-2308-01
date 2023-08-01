package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/carts")
@RequiredArgsConstructor
public class CartController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCart(@RequestBody CartDto cartDto) {
        return ResponseEntity.ok("Cart ID " + cartDto.getId() + " created successfully!");
    }

    @GetMapping(value = "{cartId}/products")
    public ResponseEntity<String> getProductsInCart(@PathVariable Long cartId) {
        return ResponseEntity.ok("Products of cart ID " + cartId + " : chair, bed, curtain");
    }

    @PutMapping(value = "{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProductToCart(@RequestBody ProductDto productDto, @PathVariable Long cartId) {
        return ResponseEntity.ok("Product " + productDto.getName() + " added to cart " + cartId);
    }

    @DeleteMapping(value = "{cartId}/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long cartId, @PathVariable Long productId) {
        return ResponseEntity.ok("Product ID " + productId + " has been deleted from cart ID " + cartId);
    }

    @PostMapping(value = "{cartId}/createOrder")
    public ResponseEntity<String> createOrderFromCart(@PathVariable Long cartId) {
        return ResponseEntity.ok("Order from cart ID " + cartId + " created");
    }

}
