package com.rest_api.shoppingcart.services;

import com.rest_api.shoppingcart.entities.Buyer;
import com.rest_api.shoppingcart.repositories.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private BuyerRepository buyerRepository;

    public Optional<Buyer> createBuyer(Buyer buyer) {
        try {
            buyerRepository.save(buyer);
            return buyerRepository.findByUsername(buyer.getUsername());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public Optional<Buyer> getUserByUsername(String username) {
        return buyerRepository.findByUsername(username);
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public boolean disableBuyer(Long buyerId) {
        try {
            Optional<Buyer> optBuyer = buyerRepository.findById(buyerId);
            optBuyer.orElseThrow().setDisabled(true);
            buyerRepository.save(optBuyer.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteBuyer(Buyer buyer) {
        try {
            Optional<Buyer> optBuyer = buyerRepository.findById(buyer.getUserId());
            buyerRepository.delete(optBuyer.orElseThrow());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
