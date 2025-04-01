package com.example.NguyenLucSongNguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenLucSongNguyen.domain.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Long>{
    
}
