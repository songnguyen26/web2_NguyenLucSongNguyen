package com.example.NguyenLucSongNguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NguyenLucSongNguyen.domain.Cart;

public interface CartRepo extends JpaRepository<Cart,Long> {
    
}
