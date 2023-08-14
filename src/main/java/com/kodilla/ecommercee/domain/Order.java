package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "carts_id")
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Cart getCart(){
        return cart;
    }

    @Column(name = "customers_id")
    private Long customerID;


    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    // private List<Product> items;
}
