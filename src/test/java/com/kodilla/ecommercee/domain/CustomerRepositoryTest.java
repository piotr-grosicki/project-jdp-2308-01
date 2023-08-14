package com.kodilla.ecommercee.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
   // private CustomerRepository customerRepository;


    //Test for CRUD
    @Test
    void shouldCreateCustomer() {
        //Given
        Cart cart1 = new Cart(7L, null);
        List<Cart> carts1 = new ArrayList<>();
        carts1.add(cart1);
//        Customer customer = new Customer(null, "testUser55",
//                    false, "KeyForTestUser55", carts1);

        //When
      //  Customer testCustomer = customerRepository.save(customer);


        //Then
//        Assertions.assertNotNull(testCustomer.getId());
//        Assertions.assertFalse(testCustomer.isLocked());
//        Assertions.assertEquals("KeyForTestUser55", testCustomer.getCustomerKey());

        //CleanUp
      //  customerRepository.deleteById(testCustomer.getId());



    }


    @Test
    void shouldFindCustomerById() {

        //Given
        Cart cart1 = new Cart(7L, null);
        List<Cart> carts2 = new ArrayList<>();
        carts2.add(cart1);
//        Customer customer = new Customer(null, "testUser55", "" ,
//                    false, "KeyForTestUser", carts2);

        //When
     //   Optional<Customer> testCustomer = customerRepository.findById(customer.getId());

        //Then
//        Assertions.assertTrue(testCustomer.isPresent());
//        Assertions.assertNotNull(testCustomer.get().getId());

        //CleanUp
      //  customerRepository.deleteById(testCustomer.get().getId());
    }

    @Test
    void shouldUpdateCustomer() {
        //Given
        Cart cart1 = new Cart(7L,null);
        Cart cart2 = new Cart(2L,null);
        List<Cart> carts3 = new ArrayList<>();
        carts3.add(cart1);
        carts3.add(cart2);

//        Customer customer = new Customer(null, "testUser55", "" ,
//                    false, "KeyForTestUser", carts3);
//        customerRepository.save(customer);

        //When
//        Assertions.assertNotNull(customer);
//        customer.setLocked(true);
//        customer.setLogin("new login");
//        carts3.remove(1);
//        customer.setCarts(carts3);
//        customerRepository.flush();

        //Then
//        Assertions.assertTrue(customer.isLocked());
//        Assertions.assertEquals("new login", customer.getLogin());


        //CleanUp
//        customerRepository.deleteById(customer.getId());

    }

    @Test
    void shouldDeleteCustomer() {
        //Given
        Cart cart1 = new Cart(7L,null);
        List<Cart> carts4 = new ArrayList<>();
        carts4.add(cart1);
      //  Customer customer = new Customer(null, "testUser55", false, "KeyForTestUser55", carts4);


        //When
//        Customer testCustomer = customerRepository.save(customer);
//        Assertions.assertNotNull(testCustomer.getId());
//        customerRepository.deleteById(testCustomer.getId());


        //Then
//        Assertions.assertNull(testCustomer.getId());


        //CleanUp
//        customerRepository.deleteById(customer.getId());

    }


//Tests for Relationships
//    @Autowired
//    private OrderRepository orderRepository;


    @Test
    void testOneToOneWithCart() {
   //Cart Repository not existing
        /*
        //Given
        Cart cart1 = new Cart(2L);
        List<Cart> carts5 = new ArrayList<>();
        carts5.add(cart1);


        Customer customer = new Customer(null, "relationship test", false, "test key", carts5);

        customerRepository.save(customer);
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //When
        Cart retrievedCart1 = cartRepository.find(Cart.class, cart1.getId());
        Cart retrievedCart2 = cartRepository.find(Cart.class, cart2.getId());

        //Then
        Assertions.assertEquals(customer, retrievedOrder1.getCustomer());
        Assertions.assertNotEquals(customer, retrievedOrder2.getCustomer());

        //CleanUp
        cartRepository.deleteById(retrievedCart1.getId());
        cartRepository.deleteById(retrievedCart2.getId());
        */
    }

    @Test
    void testManyToOneWithOrder() {
    // Order Entity and Repository not existing, test cannot compile
        /*
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        List<Cart> carts7 = new ArrayList<>();
        carts7.add(new Cart(1L, 4L));
        Customer customer = new Customer(null, "relationship test", "",
                false, "test key", carts7);
        customerRepository.save(customer);
        orderRepository.save(order1);
        orderRepository.save(order2);

        //When
        Order retrievedOrder1 = orderRepository.find(Order.class, order1.getId());
        Order retrievedOrder2 = orderRepository.find(Order.class, order2.getId());

        //Then
       Assertions.assertEquals(customer, retrievedOrder1.getCustomer());
       Assertions.assertEquals(customer, retrievedOrder2.getCustomer());

        //CleanUp
        orderRepository.deleteById(retrievedOrder1.getId());
        orderRepository.deleteById(retrievedOrder2.getId());
     */
    }
}
