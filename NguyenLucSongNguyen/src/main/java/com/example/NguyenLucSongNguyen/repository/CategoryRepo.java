package com.example.NguyenLucSongNguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenLucSongNguyen.domain.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    
}
