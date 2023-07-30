package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Long orderId;
    private Long customerId;
    private Long cartId;

    public OrderDto() {

    }
}