package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
