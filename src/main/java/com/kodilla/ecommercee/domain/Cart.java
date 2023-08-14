package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "CARTS")
public class Cart {


    @Id
    @GeneratedValue
    private Long id;

    /*
    @Column(name = "customer_id")
    private Long customerId;
*/


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    public Customer customer;




/*
    @OneToMany
    @JoinColumn(name = "carts_id")
    public List<Product> getProducts() {
        List<Product> items = new ArrayList<>();
        return items;
    }
  */

}
