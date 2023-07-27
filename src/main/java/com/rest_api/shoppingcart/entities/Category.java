package com.rest_api.shoppingcart.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Long categoryId;

  @Column(nullable = false)
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "category", cascade = CascadeType.REFRESH)
  private List<Product> products;
}
