package com.springboot.advaced_jpa.data.repository;

import com.querydsl.core.types.Predicate;
import com.springboot.advaced_jpa.data.entity.Product;
import com.springboot.advaced_jpa.data.entity.QProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;


@SpringBootTest
public class QProductRepositoryTest {

    @Autowired
    QProductRepository qProductRepository;

    @Test
    public void queryDSLTest1() {

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


        Product savedProduct1 = qProductRepository.save(product1);
        Product savedProduct2 = qProductRepository.save(product2);
        Product savedProduct3 = qProductRepository.save(product3);

        Predicate predicate = QProduct.product.name.containsIgnoreCase("펜")
                .and(QProduct.product.price.between(1000,2500));

        Optional<Product> foundProduct = qProductRepository.findOne(predicate);

        if(foundProduct.isPresent()) {
            Product product = foundProduct.get();
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }

    @Test
    public void queryDSLTest2() {
        Product product1 = new Product();
        product1.setName("��");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdateAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("��");
        product2.setPrice(5000);
        product2.setStock(350);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdateAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("��");
        product3.setPrice(10000);
        product3.setStock(150);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdateAt(LocalDateTime.now());


        Product savedProduct1 = qProductRepository.save(product1);
        Product savedProduct2 = qProductRepository.save(product2);
        Product savedProduct3 = qProductRepository.save(product3);

        QProduct qProduct = QProduct.product;

        Iterable<Product> productList = qProductRepository.findAll(
                qProduct.name.contains("��")
                        .and(qProduct.price.between(1000,10000))
        );

        for(Product product : productList) {
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }
}

