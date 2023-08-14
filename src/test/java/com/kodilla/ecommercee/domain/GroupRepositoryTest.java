package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class GroupRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getGroup() {
        //Given
        Group group = new Group("Sanitizers");

        //When
        groupRepository.save(group);

        //Then
        long id = group.getId();
        Optional<Group> optionalGroup = groupRepository.findById(id);
        assertTrue(optionalGroup.isPresent());

    }

    @Test
    void getGroups() {
        //Given
        Group group1 = new Group("Beverages");
        Group group2 = new Group("Snacks");

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        long id1 = group1.getId();
        long id2 = group2.getId();
        List<Group> groupList = new ArrayList<>();
        groupList.add(groupRepository.findById(id1).get());
        groupList.add(groupRepository.findById(id2).get());

        //Then
        assertEquals(2, groupList.size());
    }

    @Test
    void updateGroup() {
        //Given
        Group group1 = new Group("Textile");

        //When
        groupRepository.save(group1);
        group1.setName("Fabrics");
        groupRepository.save(group1);

        //Then
        assertEquals("Fabrics", groupRepository.findById(1L).get().getName());

    }

    @Test
    void oneGroupManyProducts() {
        //Given
        Product product1 = new Product("Skirt", "It's a beautiful skirt");
        Product product2 = new Product("Jersey", "An XL sized jersey");
        List<Product> groupProducts = new ArrayList<>();
        groupProducts.add(product1);
        groupProducts.add(product2);
        Group group1 = new Group("Clothes", groupProducts);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        groupRepository.save(group1);
        long id = group1.getId();

        //Then
        Assertions.assertEquals(2, groupRepository.findById(id).get().getProducts().size());

    }
}
