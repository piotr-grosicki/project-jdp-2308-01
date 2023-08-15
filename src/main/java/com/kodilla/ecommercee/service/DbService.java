package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final GroupRepository groupRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(long id) throws NoSuchElementException{
        return productRepository.findById(id).get();
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(long id) throws NoSuchElementException {
        return orderRepository.findById(id).get();
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);

    public Group getGroup(long id) throws NoSuchElementException {
        return groupRepository.findById(id).get();
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);

    }

}
