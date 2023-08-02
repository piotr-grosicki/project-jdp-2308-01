package com.kodilla.ecommercee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*Jeszcze nie jest utworzona
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;*/

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    /*public Product(Long groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }*/

    public Product() {
    }

    public Long getId() {
        return id;
    }

    /*public Long getGroupId() {
        return groupId;
    }*/

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void setGroup(Group group) {
        this.group = group;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
