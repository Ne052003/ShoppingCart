package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productReferences")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_id")
    private Long referenceId;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
