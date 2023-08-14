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
    void getOrderById() {
        //Given
        Cart cart = new Cart();
        Customer customer = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf");
        Order order = new Order(cart, customer);

        //When
        orderRepository.save(order);

        //Then
        long id = order.getId();
        Optional<Order> optionalOrder = orderRepository.findById(id);
        assertTrue(optionalOrder.isPresent());

    }

    @Test
    void getOrders() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Customer customer1 = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf");
        Customer customer2 = new Customer("ManMan", "awfweg@gmail.com", false, "hnkuunyerbtesr");
        Order order1 = new Order(cart1, customer1);
        Order order2 = new Order(cart2, customer2);

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        long id1 = order1.getId();
        long id2 = order2.getId();
        List<Order> orderList = new ArrayList<>();
        orderList.add(orderRepository.findById(id1).get());
        orderList.add(orderRepository.findById(id2).get());

        //Then
        assertEquals(2, orderList.size());
        assertTrue(orderRepository.findById(id1).isPresent());
        assertTrue(orderRepository.findById(id2).isPresent());
    }

}
