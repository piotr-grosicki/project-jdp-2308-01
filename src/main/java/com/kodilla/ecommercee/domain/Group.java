package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "NAME")
    private String name;

//    @OneToMany(
//            targetEntity = Product.class,
//            mappedBy = "group",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//     private List<Product> products = new ArrayList<>();

}
