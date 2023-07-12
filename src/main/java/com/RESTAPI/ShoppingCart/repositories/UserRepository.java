package com.RESTAPI.ShoppingCart.repositories;

import com.RESTAPI.ShoppingCart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {


}
