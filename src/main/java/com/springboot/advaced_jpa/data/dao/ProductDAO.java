package com.springboot.advaced_jpa.data.dao;

import com.springboot.advaced_jpa.data.entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProduct(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
