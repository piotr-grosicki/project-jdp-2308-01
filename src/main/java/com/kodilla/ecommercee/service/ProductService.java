package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.GenericEntityRepository;
import com.kodilla.ecommercee.Product;
import com.kodilla.ecommercee.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product saveProduct(final Product product) {
        return repository.save(product);
    }

    public Product getProduct(final Long productId) throws Exception {
        return repository.findById(productId).orElseThrow(Exception::new);
    }
}
