package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Brand;

public interface BrandRepo {
    Brand createBrand(Brand brand);
    Brand updateBrand(Long brandId,Brand brand);
    String deleteBrandById(Long brandId);
    List<Brand> getAllBrand();
    Optional<Brand> getBrandById(Long brandId);
}
