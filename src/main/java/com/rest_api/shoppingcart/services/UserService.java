package com.rest_api.shoppingcart.services;

import com.rest_api.shoppingcart.entities.Buyer;
import com.rest_api.shoppingcart.repositories.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private BuyerRepository buyerRepository;

    public boolean disableBuyer(Buyer buyer) {
        Optional<Buyer> optBuyer = buyerRepository.findById(buyer.getUserId());
        if (optBuyer.isPresent()) {
            optBuyer.get().setDisabled(true);
            return true;
        }
        return false;
    }
}
