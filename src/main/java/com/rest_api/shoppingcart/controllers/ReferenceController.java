package com.rest_api.shoppingcart.controllers;

import com.rest_api.shoppingcart.entities.Reference;
import com.rest_api.shoppingcart.services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/references")
public class ReferenceController {
    @Autowired
    private ReferenceService referenceService;

    @PostMapping
    public ResponseEntity<Void> createReference(@RequestBody Reference reference) {
        boolean created = referenceService.createReference(reference);
        return created ? ResponseEntity.status(HttpStatus.CREATED).build()
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
