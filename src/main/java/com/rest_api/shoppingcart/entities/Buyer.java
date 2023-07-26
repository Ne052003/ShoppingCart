package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Buyer extends User{
    @Column
    private Boolean disabled;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;

    @OneToMany(mappedBy = "buyer")
    private List<Reference> references;
}
