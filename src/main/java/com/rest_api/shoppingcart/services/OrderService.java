package com.rest_api.shoppingcart.services;

import com.rest_api.shoppingcart.entities.Order;
import com.rest_api.shoppingcart.entities.User;
import com.rest_api.shoppingcart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> createOrder(Order order) {
        try {
            orderRepository.save(order);
            return orderRepository.findById(order.getOrderId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Order> updateOrder(Order order) {
        Optional<Order> optOrder = orderRepository.findById(order.getOrderId());
        if (optOrder.isPresent()) {
            orderRepository.save(order);
            return optOrder;
        }
        return Optional.empty();
    }

    public boolean cancelOrder(Long orderId) {
        Optional<Order> optOrder = orderRepository.findById(orderId);
        if (optOrder.isPresent() && !optOrder.get().getCancelled()) {
            optOrder.get().setCancelled(true);
            orderRepository.save(optOrder.get());
            return true;
        }
        return false;
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByBuyer(User buyer) {
        return orderRepository.findByBuyer(buyer);
    }
}
