package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "references")
public class Reference {

    @Id
    @Column(name = "reference_id")
    private Long referenceId;

    @Column
    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyerId;

    @Column
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @Column
    private String description;
}
