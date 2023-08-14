package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class CartRepositoryTest {


    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private Customer createTestCustomer() {
        return new Customer("login", "email", false, "key1");
    }


//Test for CRUD

    @Test
    void shouldCreateCart() {
        //Given
        Cart cart = new Cart(null, createTestCustomer());

        //When
        Cart testCart = cartRepository.save(cart);

        //Then
        assertNotNull(testCart.getId());
        assertEquals("login", testCart.getCustomer().getLogin());

    }


    @Test
    void shouldFindCartById() {

        //Given
        Customer testCustomer = createTestCustomer();
        Cart cart1 = new Cart(null, testCustomer);
        cartRepository.save(cart1);

        //When
        Optional<Cart> testCart = cartRepository.findById(cart1.getId());

        //Then
        Assertions.assertTrue(testCart.isPresent());
        Assertions.assertEquals("login", testCart.get().getCustomer().getLogin());


    }

    @Test
    void shouldUpdateCart() {
        //Given
        Customer testCustomer = createTestCustomer();
        Cart cart2 = new Cart(null, testCustomer);
        cartRepository.save(cart2);


        //When
        Assertions.assertNotNull(cart2);
        boolean newLock = true;
        String newLogin = "updated login";
        testCustomer.setLocked(newLock);
        testCustomer.setLogin(newLogin);
        cartRepository.save(cart2);

        //Then
        Optional<Cart> updatedCart = cartRepository.findById(cart2.getId());
        Assertions.assertTrue(updatedCart.isPresent());
        Assertions.assertEquals(newLock, updatedCart.get().getCustomer().isLocked());
        Assertions.assertEquals(newLogin, updatedCart.get().getCustomer().getLogin());

        //CleanUp
        cartRepository.deleteById(cart2.getId());

    }

    @Test
    void shouldDeleteCart() {
        //Given
        Cart cart3 = new Cart(null, createTestCustomer());

        //When
        Cart testCart = cartRepository.save(cart3);
        assertNotNull(testCart.getId());
        cartRepository.deleteById(testCart.getId());

        //Then
        Optional<Cart> expected = cartRepository.findById(testCart.getId());
        Assertions.assertFalse(expected.isPresent());


    }


//Tests for Relationships


    @Test
    void testOneToOneWithCustomer() {
      /*
        //Given
        CustomerRepository customerRepository;
        Cart cart4 = new Cart(null, createTestCustomer());

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

        Cart cart5 = new Cart(null, createTestCustomer());


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

        Cart cart6 = new Cart(null, createTestCustomer());
        Cart cart7 = new Cart(null, createTestCustomer());
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
