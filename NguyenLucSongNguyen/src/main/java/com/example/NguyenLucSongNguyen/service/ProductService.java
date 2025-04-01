package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Product;

public interface ProductService {
     Product createProduct(Product product);
     List<Product> getAllProducts();
     Product updateProduct(Long productId, Product product);
     String deleteProduct(Long productId);
     Optional<Product> getProductById(Long productId);
}
