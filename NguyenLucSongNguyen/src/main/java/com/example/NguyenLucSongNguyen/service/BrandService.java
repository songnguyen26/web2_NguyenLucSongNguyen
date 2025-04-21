package com.example.NguyenLucSongNguyen.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.dto.BrandDTO;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);
    BrandDTO updateBrand(Long brandId,BrandDTO brandDTO);
    String deleteBrandById(Long brandId);
    Page<Brand> getAllBrand(Pageable pageable);
    BrandDTO getBrandById(Long brandId);
}
