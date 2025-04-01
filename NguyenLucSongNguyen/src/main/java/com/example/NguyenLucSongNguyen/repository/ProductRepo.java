package com.example.NguyenLucSongNguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenLucSongNguyen.domain.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    
}
