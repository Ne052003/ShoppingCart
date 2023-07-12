package com.RESTAPI.ShoppingCart.repositories;

import com.RESTAPI.ShoppingCart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
