package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
