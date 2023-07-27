package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Category;
import com.rest_api.shoppingcart.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    List<Product> findByNameContaining(String name);
}
