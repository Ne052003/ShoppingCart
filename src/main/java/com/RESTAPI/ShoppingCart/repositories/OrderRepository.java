package com.RESTAPI.ShoppingCart.repositories;

import com.RESTAPI.ShoppingCart.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
