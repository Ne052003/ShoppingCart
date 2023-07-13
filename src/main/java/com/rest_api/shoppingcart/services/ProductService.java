package com.rest_api.shoppingcart.services;

import com.rest_api.shoppingcart.entities.Category;
import com.rest_api.shoppingcart.entities.Product;
import com.rest_api.shoppingcart.repositories.CategoryRepository;
import com.rest_api.shoppingcart.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired ProductRepository productRepository;
  @Autowired CategoryRepository categoryRepository;

  public Optional<Product> createProduct(Product product) {
    if (isInvalidProduct(product)) {
      return Optional.empty();
    }

    Optional<Category> category = getCategoryIfExists(product.getCategory().getCategoryId());
    if (category.isEmpty()) {
      return Optional.empty();
    }

    product.setCategory(category.get());
    return Optional.of(productRepository.save(product));
  }

  public Optional<Product> updateProduct(Product product) {
    Optional<Product> existingProduct = productRepository.findById(product.getProductId());

    if (isInvalidProduct(product) || existingProduct.isEmpty()) {
      return Optional.empty();
    }

    Optional<Category> category = getCategoryIfExists(product.getCategory().getCategoryId());
    if (category.isEmpty()) {
      return Optional.empty();
    }

    Product updatedProduct = existingProduct.get();
    updatedProduct.setName(product.getName());
    updatedProduct.setPrice(product.getPrice());
    updatedProduct.setCategory(category.get());

    return Optional.of(productRepository.save(updatedProduct));
  }

  public boolean deleteProduct(Long productId) {
    if (productRepository.existsById(productId)) {
      productRepository.deleteById(productId);
      return true;
    }
    return false;
  }


  public Optional<Product> getProductById(Long productId) {
    return productRepository.findById(productId);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public boolean setProductEnabled(Long productId, boolean enabled) {
    return productRepository
        .findById(productId)
        .map(
            product -> {
              product.setEnabled(enabled);
              productRepository.save(product);
              return true;
            })
        .orElse(false);
  }

  private boolean isInvalidProduct(Product product) {
    return product.getName() == null || product.getPrice() <= 0d || product.getCategory() == null;
  }

  private Optional<Category> getCategoryIfExists(Long categoryId) {
    return categoryRepository.findById(categoryId);
  }
}
