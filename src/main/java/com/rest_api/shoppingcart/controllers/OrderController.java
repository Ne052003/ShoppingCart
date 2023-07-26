package com.rest_api.shoppingcart.controllers;

import com.rest_api.shoppingcart.entities.Buyer;
import com.rest_api.shoppingcart.entities.Order;
import com.rest_api.shoppingcart.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(Order order) {
        Optional<Order> optOrder = orderService.createOrder(order);
        if (optOrder.isPresent()) {
            return ResponseEntity.created(URI.create("/" + order.getOrderId())).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(Order order) {
        Optional<Order> optOrder = orderService.updateOrder(order);
        if (optOrder.isPresent()) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/cancel/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        if (orderService.cancelOrder(orderId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Optional<Order> optOrder = orderService.getOrderById(orderId);
        return optOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(Buyer user) {
        List<Order> orders = orderService.getOrdersByUser(user);
        if (!orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        }
        return ResponseEntity.badRequest().build();
    }
}
