package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
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


    //private Customer customer;
    //private Order order;
    //private List<Product> items;


    /*
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customers")
    @JoinColumn(name = "customers_id")
    public Customer getCustomer(){
        return customer;
    }
     */

    /*
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    @JoinTable(
        name = "products",
        joinColumns = {@JoinColumn(name = "products_product_id", referencedColumnName = "products_product_id")},
        inverseJoinColumns = {@JoinColumn(name = "carts_id", referencedColumnName = "carts_id")}
    public List<Product> getProducts() {
        return items;
    }
    */


    /*
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
    @JoinColumn(name = "orders_id")
    public Order getOrder(){
        return order;
    }
    */



}
