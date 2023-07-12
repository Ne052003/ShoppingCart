package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
