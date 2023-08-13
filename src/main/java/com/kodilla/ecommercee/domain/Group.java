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
@Getter
@Setter
@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
     private List<Product> products = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
