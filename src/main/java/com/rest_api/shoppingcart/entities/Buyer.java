package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@DiscriminatorValue("BUYER")
public class Buyer extends User {
    @Column
    private Boolean disabled;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;
}
