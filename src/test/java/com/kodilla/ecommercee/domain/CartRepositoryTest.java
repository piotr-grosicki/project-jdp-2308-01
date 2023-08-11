package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CartRepositoryTest {


    @Autowired
    private CartRepository cartRepository;


    //Test for CRUD
    @Test
    void shouldCreateCart() {
        //Given
        Cart cart = new Cart(1L, 2L);

        //When
        Cart testCart = cartRepository.save(cart);

        //Then
        Assertions.assertEquals(1L, testCart.getId());
        Assertions.assertEquals(2L, testCart.getCustomerId());


        //CleanUp
        cartRepository.deleteById(testCart.getId());

    }


    @Test
    void shouldFindCartById() {

        //Given
        Cart cart1 = new Cart(1L, 55L);
        cartRepository.save(cart1);

        //When
        Optional<Cart> testCart = cartRepository.findById(cart1.getId());

        //Then
        Assertions.assertTrue(testCart.isPresent());


        //CleanUp
        cartRepository.deleteById(testCart.get().getId());
    }

    @Test
    void shouldUpdateCart() {
        //Given
        Cart cart2 = new Cart(7L, 55L);
        cartRepository.save(cart2);


        //When
        Assertions.assertNotNull(cart2);
//@Setter do Cart
        // cart2.setCustomerId(22L);
        cartRepository.flush();

        //Then
        //   Assertions.assertEquals(22L, cart2.getCustomerId());


        //CleanUp
     //   cartRepository.deleteById(cart2.getId());

    }

    @Test
    void shouldDeleteCart() {
        //Given
        Cart cart3 = new Cart(8L, 55L);

        //When-Then
        Cart testCart = cartRepository.save(cart3);
        Assertions.assertEquals(55L, cart3.getCustomerId());
        cartRepository.deleteById(testCart.getId());


        //CleanUp


    }


//Tests for Relationships


    @Test
    void testOneToOneWithCustomer() {
      /*
        //Given
        CustomerRepository customerRepository;
        Cart cart4 = new Cart(2L, 4L);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart4);


        Customer customer = new Customer(null, "relationship test", false, "test key", carts);

        customerRepository.save(customer);
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //When
        Customer retrievedCustomer = customerRepository.find(Customer.class, customer.getId());

        //Then
        Assertions.assertEquals(carts, retrievedCustomer.getCarts());


        //CleanUp
        customerRepository.deleteById(retrievedCustomer.getId());
        */
    }

    @Test
    void testOneToOneWithOrder() {
        /*
        //Given
        OrderRepository orderRepository;
        Order order1 = new Order(1L, 3L, 5L);

        Cart cart5 = new Cart(2L, 5L);


        orderRepository.save(cart5);
        cartRepository.save(order1);


        //When
        Order retrievedOrder = orderRepository.find(Order.class, order1.getId());

        //Then
        Assertions.assertEquals(carts, retrievedCustomer.getCarts());


        //CleanUp
        customerRepository.deleteById(retrievedCustomer.getId());
        orderRepository.deleteById(order1.getId());

        */
    }


    @Test
    void testManyToManyWithProduct() {
        /*
        //Given
        ProductRepository productRepository;
        Product product1 = new Product(2L, 1L, "test1", "dummy1");
        Product product2 = new Product(5L, 1L, "test2", "dummy2");
        Product product3 = new Product(4L, 2L, "test3", "dummy3");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product2);

        Cart cart6 = new Cart(3L, 8L);
        Cart cart7 = new Cart(5L, 8L);
        List<Product> itemsOfCart5 = new ArrayList<>();
        List<Product> itemsOfCart6 = new ArrayList<>();
        itemsOfCart5.add(product1);
        itemsOfCart5.add(product3);
        itemsOfCart6.add(product2);
        itemsOfCart6.add(product3);
        cartRepository.save(cart6);
        cartRepository.save(cart7);

        //When
        cartRepository.flush();
        Optional<Cart> retrievedCart1 = cartRepository.findById(cart6.getId());
        Optional<Cart> retrievedCart2 = cartRepository.findById(cart7.getId());

        //Then
        Assertions.assertTrue(retrievedCart1.isPresent());
        Assertions.assertEquals(itemsOfCart5, retrievedCart1.getProducts());
        Assertions.assertEquals(itemsOfCart6, retrievedCart2.getProducts());


        //CleanUp
        productRepository.deleteById(product1);
        productRepository.deleteById(product2);
        productRepository.deleteById(product3);
        cartRepository.deleteById(retrievedCart1);
        cartRepository.deleteById(retrievedCart2);

*/
    }


}
