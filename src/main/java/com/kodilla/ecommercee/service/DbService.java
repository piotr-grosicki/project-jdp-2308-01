package com.kodilla.ecommercee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbService {

    public long getProducts(Long id) {
        return 5;
    }

    public void addProductToCart() {
        System.out.println("product was added");
    }

}
