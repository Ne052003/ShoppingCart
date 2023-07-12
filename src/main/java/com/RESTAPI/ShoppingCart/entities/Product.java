package com.RESTAPI.ShoppingCart.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long productId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private double price;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;
}
