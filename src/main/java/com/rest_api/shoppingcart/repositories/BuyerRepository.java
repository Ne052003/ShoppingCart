package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    public Optional<Buyer> findByUsername(String username);
}
