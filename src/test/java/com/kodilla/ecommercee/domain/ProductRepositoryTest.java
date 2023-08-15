package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    void shouldGetProducts(){
        //Given
        Product initial1 = new Product("name1", "description1");
        Product initial2 = new Product("name2", "description2");
        productRepository.save(initial1);
        productRepository.save(initial2);

        //When
        List<Product> retrieved = productRepository.findAll();

        //Then
        Assertions.assertEquals(2, retrieved.size());

    }

    @Test
    void shouldGetProduct(){
        //Given
        Product initial = new Product("name1", "description1");
        productRepository.save(initial);

        //When
        Optional<Product> retrieved = productRepository.findById(initial.getId());

        //Then
        Assertions.assertTrue(retrieved.isPresent());
        Assertions.assertEquals(initial.getName(), retrieved.get().getName());



    }

    @Test
    void shouldDeleteProduct(){
        //Given
        Product dummyProduct = new Product("test", "dummy description");
        Product tested = productRepository.save(dummyProduct);
        Assertions.assertNotNull(tested.getId());

        //When
        productRepository.deleteById(tested.getId());

        //Then
        Optional<Product> expected = productRepository.findById(tested.getId());
        Assertions.assertFalse(expected.isPresent());
    }

    @Test
    void shouldUpdateProduct(){
        //Given
        Product dummy = new Product("name", "description");
        productRepository.save(dummy);
        Assertions.assertNotNull(dummy.getId());

        //When
        String newName = "updated name";
        String newDescription = " updated description";
        dummy.setName(newName);
        dummy.setDescription(newDescription);
        productRepository.save(dummy);

        //Then
        Optional<Product> updatedProduct = productRepository.findById(dummy.getId());
        Assertions.assertTrue(updatedProduct.isPresent());
        Assertions.assertEquals(newName, updatedProduct.get().getName());
        Assertions.assertEquals(newDescription, updatedProduct.get().getDescription());

    }

    @Test
    void shouldCreateProduct(){
        //Given
        Product newProduct = new Product("name", "description");

        //When
        Product actual = productRepository.save(newProduct);

        //Then
        assertNotNull(actual.getId());
        assertEquals(newProduct.getName(), actual.getName());

    }

    @Test
    void testManyToOneWithGroup(){
        //Given
        Group group1 = new Group("gr1");
        Group group2 = new Group("gr2");
        groupRepository.save(group1);
        groupRepository.save(group2);

        Product product1 = new Product(group1, new ArrayList<>(),"test1", "dummy1");
        Product product2 = new Product(group2, new ArrayList<>(),"test2", "dummy2");
        Product product3 = new Product(group1, new ArrayList<>(),"test3", "dummy3");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        Optional<Product> product1ById = productRepository.findById(product1.getId());
        Optional<Product> product2ById = productRepository.findById(product2.getId());

        //Then
        Assertions.assertTrue(product1ById.isPresent());
        Group retrievedGroup1 = product1ById.get().getGroup();
        Assertions.assertTrue(product2ById.isPresent());
        Group retrievedGroup2 = product2ById.get().getGroup();

        Assertions.assertNotNull(retrievedGroup1);
        Assertions.assertNotNull(retrievedGroup2);

    }

    @Test
    void testManyToManyWithCart(){
        //Given
        Cart cart1 = new Cart(null, new Customer("login1", "email1", false, "key1"));
        Cart cart2 = new Cart(null, new Customer("login2", "email2", false, "key2"));
        Cart cart3 = new Cart(null, new Customer("login3", "email3", false, "key3"));

        List<Cart> list1 = new ArrayList<>();
        List<Cart> list2 = new ArrayList<>();
        list1.add(cart1);
        list1.add(cart2);
        list2.add(cart3);

        Group group1 = new Group("gr1");
        Product product1 = new Product(group1, list1, "prod1", "dummy1");
        Product product2 = new Product(group1, list2, "prod2", "dummy2");
        productRepository.save(product1);
        productRepository.save(product2);


        //When

        Optional<Cart> retrievedCart1 = cartRepository.findById(cart1.getId());
        Optional<Cart> retrievedCart2 = cartRepository.findById(cart2.getId());
        Optional<Cart> retrievedCart3 = cartRepository.findById(cart3.getId());

        Optional<Product> retrievedProduct1 = productRepository.findById(product1.getId());
        Optional<Product> retrievedProduct2 = productRepository.findById(product2.getId());

        //Then
        Assertions.assertTrue(retrievedCart1.isPresent());
        Assertions.assertTrue(retrievedCart2.isPresent());
        Assertions.assertTrue(retrievedCart3.isPresent());

        Assertions.assertTrue(retrievedProduct1.isPresent());
        Assertions.assertTrue(retrievedProduct2.isPresent());
        assertEquals(2, retrievedProduct1.get().getCarts().size());
        assertEquals(1, retrievedProduct2.get().getCarts().size());

    }


}
