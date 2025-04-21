package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;

public interface ProductService {
     ProductDTO createProduct(ProductDTO productDTO);
     List<Product> getAllProducts();
     ProductDTO updateProduct(Long productId, ProductDTO productDTO);
     String deleteProduct(Long productId);
     Optional<Product> getProductById(Long productId);
}
