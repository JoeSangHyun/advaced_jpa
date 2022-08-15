package com.springboot.advaced_jpa.data.repository.support;

import com.springboot.advaced_jpa.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByName(String name);
}
