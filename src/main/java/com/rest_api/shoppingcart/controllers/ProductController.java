package com.rest_api.shoppingcart.controllers;

import com.rest_api.shoppingcart.entities.Product;
import com.rest_api.shoppingcart.services.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Optional<Product> createdProduct = productService.createProduct(product);
    return createdProduct
        .map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p))
        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable Long productId, @RequestBody Product product) {
    Optional<Product> updatedProduct = productService.updateProduct(product);
    return updatedProduct.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
    boolean deleted = productService.deleteProduct(productId);
    return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
    Optional<Product> product = productService.getProductById(productId);
    return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    if (products.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(products);
    }
  }

  @PatchMapping("/enabled/{productId}")
  public ResponseEntity<Void> setProductEnabled(
      @PathVariable Long productId, @RequestParam(name = "enabled") boolean enabled) {
    boolean updated = productService.setProductEnabled(productId, enabled);
    return updated ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
  }
}
