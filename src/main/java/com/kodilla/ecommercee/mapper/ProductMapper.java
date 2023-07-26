package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.Product;
import com.kodilla.ecommercee.ProductController;
import com.kodilla.ecommercee.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getGroupId(),
                productDto.getName(),
                productDto.getDescription()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getGroupId(),
                product.getName(),
                product.getDescription()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
