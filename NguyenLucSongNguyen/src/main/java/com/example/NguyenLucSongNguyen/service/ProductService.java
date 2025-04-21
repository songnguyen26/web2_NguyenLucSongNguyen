package com.example.NguyenLucSongNguyen.service;

import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
     ProductDTO createProduct(ProductDTO productDTO);
     Page<Product> getAllProducts(Pageable pageable);
     ProductDTO updateProduct(Long productId, ProductDTO productDTO);
     String deleteProduct(Long productId);
     Optional<Product> getProductById(Long productId);
}
