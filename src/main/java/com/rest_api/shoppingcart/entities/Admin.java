package com.rest_api.shoppingcart.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
}
