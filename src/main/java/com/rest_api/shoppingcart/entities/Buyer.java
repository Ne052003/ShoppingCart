package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("BUYER")
public class Buyer extends User {
    @Column
    private String buyerProperty;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;
}
