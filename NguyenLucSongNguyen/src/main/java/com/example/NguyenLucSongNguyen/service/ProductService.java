package com.example.NguyenLucSongNguyen.service;

import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.dto.response.ProductResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
     ProductDTO createProduct(ProductDTO productDTO);
     ProductResponse getAllProducts(Integer pageSize,Integer pageNumber,String sortBy,String sortOrder);
     ProductDTO updateProduct(Long productId, ProductDTO productDTO);
     String deleteProductById(Long productId);
     ProductDTO getProductById(Long productId);
}
