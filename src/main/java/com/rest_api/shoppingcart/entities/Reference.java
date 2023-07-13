package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "references")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
