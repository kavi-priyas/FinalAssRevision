package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product>findProduct(){
        return productRepository.findAll();
    }
    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    
    }
    public Product updateProduct(Long id,Product updatedproduct){
        return productRepository.findById(id)
        .map(product->
            {
                product.setName(updatedproduct.getName());
                product.setPrice(updatedproduct.getPrice());
                product.setQuantity(updatedproduct.getQuantity());
                return productRepository.save(product);
            } ).orElseThrow(()->new RuntimeException("Product not found"+id));
        }
            public void deleteProduct(Long id){
                productRepository.deleteById(id);
            }
    }

