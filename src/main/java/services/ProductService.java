package services;

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

  public Product createProduct(Product product) {
    if (isInvalidProduct(product)) {
      return null;
    }

    Category category = getCategoryIfExists(product.getCategory().getCategoryId());
    if (category == null) {
      return null;
    }

    product.setCategory(category);
    return productRepository.save(product);
  }

  public Product updateProduct(Product product) {
    Optional<Product> existingProduct = productRepository.findById(product.getProductId());

    if (isInvalidProduct(product) || existingProduct.isEmpty()) {
      return null;
    }

    Category category = getCategoryIfExists(product.getCategory().getCategoryId());
    if (category == null) {
      return null;
    }

    Product updatedProduct = existingProduct.get();
    updatedProduct.setName(product.getName());
    updatedProduct.setPrice(product.getPrice());
    updatedProduct.setCategory(category);

    return productRepository.save(updatedProduct);
  }

  public void deleteProduct(Long productId) {
    productRepository.findById(productId).ifPresent(productRepository::delete);
  }

  public Product getProductById(Long productId) {
    return productRepository.findById(productId).orElse(null);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public boolean setProductEnabled(Long productId, boolean enabled) {
    return productRepository.findById(productId)
            .map(product -> {
              product.setEnabled(enabled);
              productRepository.save(product);
              return true;
            })
            .orElse(false);
  }


  private boolean isInvalidProduct(Product product) {
    return product.getName() == null || product.getPrice() <= 0d || product.getCategory() == null;
  }

  private Category getCategoryIfExists(Long categoryId) {
    return categoryRepository.findById(categoryId).orElse(null);
  }
}
