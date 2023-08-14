package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

//    @Column(name = "carts_id")

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carts_id")
    private Cart cart;

    @Column(name = "customers_id")
    private Long customerID;

    //relationship to Customers can't be settled without Cart class created
   /*
    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
    */

//    private List<Product> items;
}
