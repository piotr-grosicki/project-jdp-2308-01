package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Long orderId;
    private Long customerId;
    private Long cartId;

    public OrderDto() {}
}