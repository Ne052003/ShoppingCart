package com.rest_api.shoppingcart.controllers;

import com.rest_api.shoppingcart.entities.Buyer;
import com.rest_api.shoppingcart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        Optional<Buyer> optBuyer = userService.createBuyer(buyer);
        return optBuyer.map(value -> ResponseEntity.created(URI.create("/" + value.getUsername())).body(value)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{buyerId}")
    public ResponseEntity<?> disableBuyer(@PathVariable Long buyerId) {
        if (userService.disableBuyer(buyerId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserByUsername(@RequestParam("username") String username) {
        Optional<Buyer> optBuyer = userService.getUserByUsername(username);
        if (optBuyer.isPresent()) {
            return ResponseEntity.ok(optBuyer);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = userService.getAllBuyers();
        if (!buyers.isEmpty()) {
            return ResponseEntity.ok(buyers);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBuyer(@RequestBody Buyer buyer) {
        if (userService.deleteBuyer(buyer)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
