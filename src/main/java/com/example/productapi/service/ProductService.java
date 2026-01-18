package com.example.productapi.service;

import com.example.productapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private Long idCounter = 1L;


    public Product createProduct(Product product){
        product.setId(idCounter++);
        products.add(product);
        return product;
    }
    public List<Product> getAllProducts(){
        return products;
    }
    public Optional<Product> getProductById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public Product updateProduct(Long id, Product updatedProduct){
        Product existing = getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        return existing;
    }
    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }





}
