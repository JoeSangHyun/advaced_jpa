package com.springboot.advaced_jpa.data.repository.support;

import com.springboot.advaced_jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
}
