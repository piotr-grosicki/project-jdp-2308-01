package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void getGroup() {
        //Given
        Cart cart = new Cart();
        Customer customer = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf");
        Order order = new Order();

        //When
        orderRepository.save(group);

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

}
