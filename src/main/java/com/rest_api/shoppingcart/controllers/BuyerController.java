package com.rest_api.shoppingcart.controllers;

import com.rest_api.shoppingcart.entities.Buyer;
import com.rest_api.shoppingcart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    private UserService userService;

    public ResponseEntity<?> disableBuyer(Buyer buyer) {
        if (userService.disableBuyer(buyer)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
