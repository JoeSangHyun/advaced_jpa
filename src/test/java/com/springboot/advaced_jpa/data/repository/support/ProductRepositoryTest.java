package com.springboot.advaced_jpa.data.repository.support;

import com.springboot.advaced_jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class ProductRepositoryTest {


    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameTest() {

        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdateAt(LocalDateTime.now());

        Product product2 = new Product();
        product1.setName("펜");
        product2.setPrice(5000);
        product2.setStock(350);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdateAt(LocalDateTime.now());

        Product product3 = new Product();
        product1.setName("펜");
        product3.setPrice(10000);
        product3.setStock(150);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdateAt(LocalDateTime.now());


        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);

        List<Product> productList = productRepository.findByName("펜");

        for(Product product : productList) {
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }
}
