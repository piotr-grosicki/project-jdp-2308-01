package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.CustomerRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

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

    @Test
    void updateOrder() {
        //Given
        Cart cart = new Cart();
        Customer customer1 = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf");
        Customer customer2 = new Customer("ManMan", "awfweg@gmail.com", false, "hnkuunyerbtesr");
        Order order = new Order(cart, customer1);

        //When
        orderRepository.save(order);
        order.setCustomer(customer2);
        orderRepository.save(order);
        long id1 = order.getId();

        //Then
        assertTrue(orderRepository.findById(id1).isPresent());
        assertEquals("ManMan", orderRepository.findById(id1).get().getCustomer().getLogin());

    }

    @Test
    void deleteOrder() {
        //Given
        Cart cart = new Cart();
        Customer customer = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf");
        Order order = new Order(cart, customer);

        //When
        orderRepository.save(order);
        long id = order.getId();
        orderRepository.deleteById(id);

        //Then
        assertFalse(orderRepository.existsById(id));
    }

    @Test
    void oneCustomerManyOrders() {
        //Given
        Cart cart = new Cart();
        List<Order> orders = new ArrayList<>();
        Customer customer1 = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf", orders);
        Order order1 = new Order(cart, customer1);
        Order order2 = new Order(cart, customer1);
        orders.add(order1);
        orders.add(order2);

        //When
        customerRepository.save(customer1);
        orderRepository.save(order1);
        orderRepository.save(order2);
        long customerId = customer1.getCustomerId();

        //Then
        assertTrue(customerRepository.findById(customerId).isPresent());
        assertEquals(2, customerRepository.findById(customerId).get().getOrders().size());
    }

    @Test
    void oneCartOneOrder() {
        //Given
        Customer customer1 = new Customer("JavaMan", "jm@gmail.com", false, "efrsdvb546ujtngf");
        Cart cart1 = new Cart();
        Order order1 = new Order(cart1, customer1);
        Cart cart2 = new Cart();
        Customer customer2 = new Customer("ManMan", "awfweg@gmail.com", false, "hnkuunyerbtesr");
        Order order2 = new Order(cart2, customer2);
        cart1.setOrder(order1);
        cart2.setOrder(order2);

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        long order1Id = order1.getId();
        long order2Id = order2.getId();
        long cart1Id = cart1.getId();
        long cart2Id = cart2.getId();

        //Then
        assertTrue(cartRepository.findById(cart1Id).isPresent());
        assertTrue(cartRepository.findById(cart2Id).isPresent());
        assertEquals(order1Id, cartRepository.findById(cart1Id).get().getOrder().getId().longValue());
        assertEquals(order2Id, cartRepository.findById(cart2Id).get().getOrder().getId().longValue());

    }

}
