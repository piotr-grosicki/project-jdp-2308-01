package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "CARTS")
public class Cart {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    public Customer customer;

    @OneToOne(mappedBy = "cart")
    private Order order;

    @OneToMany
    @JoinColumn(name = "carts_id")
    public List<Product> items = new ArrayList<>();

    public Cart(Long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

}
