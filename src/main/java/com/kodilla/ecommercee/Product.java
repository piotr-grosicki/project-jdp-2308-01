package com.kodilla.ecommercee;

public class Product {
    private Long id;
    private Long groupId;
    private String name;
    private String description;

    public Product(Long id, Long groupId, String name, String description) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
