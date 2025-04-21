package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.dto.BrandDTO;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);
    BrandDTO updateBrand(Long brandId,BrandDTO brandDTO);
    String deleteBrandById(Long brandId);
    List<Brand> getAllBrand();
    BrandDTO getBrandById(Long brandId);
}
