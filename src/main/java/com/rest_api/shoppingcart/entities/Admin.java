package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
  @Column private String adminProperty;
}
