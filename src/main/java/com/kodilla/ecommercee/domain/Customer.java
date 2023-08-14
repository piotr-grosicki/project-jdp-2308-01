package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean isLocked;

    @Column(nullable = false)
    private String customerKey;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();


    public Customer(String login, String email, boolean isLocked, String customerKey) {
        this.login = login;
        this.email = email;
        this.isLocked = isLocked;
        this.customerKey = customerKey;
    }

    public Customer(String login, String email, boolean isLocked, String customerKey, List<Order> orders) {
        this.login = login;
        this.email = email;
        this.isLocked = isLocked;
        this.customerKey = customerKey;
        this.orders = orders;
    }
}



