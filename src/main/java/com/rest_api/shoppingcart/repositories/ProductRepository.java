package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Category;
import com.rest_api.shoppingcart.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategory(Category category);

  List<Product> findByNameContaining(String name);

  Page<Product> findAll(Pageable pageable);
}
