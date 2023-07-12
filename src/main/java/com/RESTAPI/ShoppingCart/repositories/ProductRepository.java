package com.RESTAPI.ShoppingCart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Long, ProductRepository> {
}
