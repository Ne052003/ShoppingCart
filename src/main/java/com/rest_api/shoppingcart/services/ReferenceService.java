package com.rest_api.shoppingcart.services;

import com.rest_api.shoppingcart.entities.Product;
import com.rest_api.shoppingcart.entities.Reference;
import com.rest_api.shoppingcart.repositories.ProductRepository;
import com.rest_api.shoppingcart.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReferenceService {
    @Autowired
    private ReferenceRepository referenceRepository;
    @Autowired
    private ProductRepository productRepository;

    public boolean createReference(Reference reference) {
        Optional<Product> optProduct = productRepository.findById(reference.getProductId().getProductId());
        if (optProduct.isPresent() && validateReference(reference)) {
            referenceRepository.save(reference);
            return true;
        }
        return false;
    }

    private boolean validateReference(Reference reference) {
        String description = reference.getDescription();
        return !(description.isEmpty() || description.isBlank());
    }
}
