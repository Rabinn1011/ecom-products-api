package com.example.productapi.service;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);  // Saves to database!
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();  // Gets from database!
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);  // Queries database!
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setDescription(updatedProduct.getDescription());
        existing.setCategory(updatedProduct.getCategory());
        existing.setStockQuantity(updatedProduct.getStockQuantity());

        return productRepository.save(existing);  // Updates database!
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);  // Deletes from database!
    }
}
