package com.example.NguyenLucSongNguyen.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
    String deleteCategoryById(Long categoryId);
    Page<Category> getAllCategory(Pageable pageable);
    CategoryDTO getCategoryById(Long categoryId);
}
