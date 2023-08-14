package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    private GroupRepository groupRepository;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                groupRepository.findById(productDto.getGroupId()).get(),
                productDto.getName(),
                productDto.getDescription()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getGroup().getId(),
                product.getName(),
                product.getDescription());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

}
