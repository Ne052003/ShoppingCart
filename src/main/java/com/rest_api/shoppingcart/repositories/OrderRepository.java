package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Order;
import com.rest_api.shoppingcart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}
