package com.rest_api.shoppingcart.repositories;

import com.rest_api.shoppingcart.entities.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference,Long> {
}
