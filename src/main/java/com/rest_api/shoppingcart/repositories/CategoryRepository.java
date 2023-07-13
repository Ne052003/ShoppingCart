package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
